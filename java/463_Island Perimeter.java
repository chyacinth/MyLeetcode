/**
 * 对每个1，看周围有多少1或墙，有多少加多少边
 */
class Solution {
    public int islandPerimeter(int[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    if (i - 1 < 0 || grid[i - 1][j] == 0) ++cnt;
                    if (j - 1 < 0 || grid[i][j - 1] == 0) ++cnt;
                    if (i + 1 >= grid.length || grid[i + 1][j] == 0) ++cnt;
                    if (j + 1 >= grid[0].length || grid[i][j + 1] == 0) ++cnt;
                }
            }
        }
        return cnt;
    }
}