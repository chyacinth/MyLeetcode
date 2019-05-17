class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        
        //     i i+1 i+2 i+k  
        // 0 1 2  3  4    5    6 7
        // N % k
        
        // a[n] = a[(n-i) % (k + 1) + i]
        int cnt = 0;
        int[] occur = new int[256];
        int[] dayCell = new int[300];
        Arrays.fill(occur, -1);
        final int[] vals = new int[] {128, 64, 32, 16, 8, 4, 2, 1};
        int val = 0;
        for (int i = 0; i < cells.length; ++i) {
            val += cells[i] * vals[i];
        }
        occur[val] = 0;
        dayCell[0] = val;
        
        for (int i = 1; i <= N; ++i) {
            val = (~((val << 1) ^ (val >> 1)) & 126);
            if (occur[val] == -1) {
                occur[val] = i;
                dayCell[i] = val;
            } else {
                int prev = occur[val];                
                int resVal = dayCell[(N - prev) % (i - prev) + prev];                
                int[] result = new int[8];
                for (int t = 0; t < 8; ++t) {
                    result[t] = ((resVal & vals[t]) == 0) ? 0 : 1;
                }
                return result;
            }
        }
        int[] result = new int[8];
        for (int i = 0; i < 8; ++i) {
            result[i] = ((val & vals[i]) == 0) ? 0 : 1;
        }
        return result;
    }
}