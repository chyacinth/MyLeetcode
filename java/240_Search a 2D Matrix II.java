/**
 * 其实很简单，看一下每一行，每一列不包含target的条件，就会发现只要比较右上角或左下角的数和target就可以一步一步删除行
 * 和列了
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) return false;
        int m = matrix[0].length;
        if (m == 0) return false;
        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] < target) { ++i; }
            else if (matrix[i][j] > target) { --j; }
            else return true;
        }
        return false;
    }
}