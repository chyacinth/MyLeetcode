class Solution {    
    private boolean valid(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }
    public int[] findDiagonalOrder(int[][] matrix) {
        boolean up = true;
        int i = 0;
        int j = 0;
        int n = matrix.length;
        if (n == 0) { return new int[0]; }
        int m = matrix[0].length;
        int[] result = new int[n * m];
        int p = 0;
        while (true) {
            result[p++] = matrix[i][j];
            if (up) {
                i -= 1;
                j += 1;
                if (!valid(i, j, n, m)) {
                    up = !up;
                    i += 1;
                }
                if (!valid(i, j, n, m)) {
                    i += 1;
                    j -= 1;
                }                
            } else {
                i += 1;
                j -= 1;
                if (!valid(i, j, n, m)) {
                    up = !up;
                    j += 1;
                }
                if (!valid(i, j, n, m)) {
                    i -= 1;
                    j += 1;
                }
            }
            if (!valid(i, j, n, m)) {
                break;
            }
        }
        return result;
    }
}