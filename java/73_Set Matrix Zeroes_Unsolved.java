/*
相当tricky的一道题，看了题解才想到。
要求常数空间。总体想法是将数组第一列和第一行作为记录某一列或某一行是否要变成零。
然后再用两个变量记录一下某一行或某一列要不要变零即可
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return;
        int m = matrix[0].length;
        if (m == 0) return;
        boolean rowZero = false, colZero = false;
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {colZero = true;}
        }
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {rowZero = true;}
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }                
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }                                    
            }
        }
        
        if (rowZero) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
        if (colZero) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}