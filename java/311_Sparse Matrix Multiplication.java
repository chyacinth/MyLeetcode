class Solution {
    
    static class LocValVec {
        List<Integer> locs = new ArrayList<>();
        List<Integer> vals = new ArrayList<>();
    }
    
    private int mult(LocValVec a, LocValVec b) {        
        int i = 0;
        int j = 0;
        int result = 0;
        while (i < a.locs.size() && j < b.locs.size()) {
            if (a.locs.get(i) < b.locs.get(j)) {
                ++i;
            } else if (a.locs.get(i) > b.locs.get(j)) {
                ++j;
            } else {
                result += a.vals.get(i) * b.vals.get(j);
                ++i;
                ++j;
            }
        }
        return result;
    }
    
    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        if (B.length == 0) { return new int[0][0]; }
        int m = B[0].length;
        if (n == 0 || m == 0) { return new int[0][0]; }
        
        LocValVec[] av = new LocValVec[n];
        for (int i = 0; i < av.length; ++i) {
            av[i] = new LocValVec();
        }
        LocValVec[] bv = new LocValVec[m];
        for (int i = 0; i < bv.length; ++i) {
            bv[i] = new LocValVec();
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < A[0].length; ++j) {
                if (A[i][j] != 0) {
                    av[i].vals.add(A[i][j]);
                    av[i].locs.add(j);
                }
            }
        }
        for (int j = 0; j < m; ++j) {
            for (int i = 0; i < B.length; ++i) {
                if (B[i][j] != 0) {
                    bv[j].vals.add(B[i][j]);
                    bv[j].locs.add(i);
                }
            }
        }
        
        int[][] result = new int[n][m];
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {                
                result[i][j] += mult(av[i], bv[j]);
            }
        }
        return result;
    }
}