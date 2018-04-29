class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int len = n, x = 0, y = 0, cnt = 0;
        while (len > 0) {
            for (int j = y; j < y + len - 1; j++) {                
                if (result[x][j] == 0) {
                    cnt += 1;
                    result[x][j] = cnt;
                }
            }
            for (int i = x; i < x + len - 1; i++) {                
                if (result[i][y + len - 1] == 0) {
                    cnt += 1;
                    result[i][y + len - 1] = cnt;
                }
            }
            for (int j = y + len - 1; j > y; j--) {                
                if (result[x + len - 1][j] == 0) {
                    cnt += 1;
                    result[x + len - 1][j] = cnt;
                }
            }
            for (int i = x + len - 1; i > x; i--) {                
                if (result[i][y] == 0) {
                    cnt += 1;
                    result[i][y] = cnt;
                }
            }
            if (result[x][y] == 0) {
                cnt += 1;
                result[x][y] = cnt;
            }
            len -= 2;
            x += 1;
            y += 1;
        }
        return result;
    }
}