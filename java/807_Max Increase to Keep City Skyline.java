/**
 * 增加grid[i][j]到Min(i行最大值，j列最大值)
 */
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] rowMax = new int[n];
        int[] colMax = new int[m];
        for (int i = 0; i < n; ++i) {
            rowMax[i] = grid[i][0];
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] > rowMax[i]) { rowMax[i] = grid[i][j]; }
                if (grid[i][j] > colMax[j]) { colMax[j] = grid[i][j]; }
            }            
        }
        int result = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                result += Math.min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }
        return result;
    }
}