/**
 * dfs
 * 不能用递归！！
 */
class Solution {
  final int[] dx = {0, -1, 0, 1};
  final int[] dy = {-1, 0, 1, 0};
  int n = 0;
  int m = 0;
  
  public int floodFill(int[][] grid, int x, int y) {
    int result = 1;
    grid[x][y] = 0;
    int tx = 0;
    int ty = 0;
    
    for (int i = 0; i < 4; i++) {
      tx = x + dx[i];
      ty = y + dy[i];
      if (tx >= 0 && tx < n && ty >= 0 && ty < m) {
        if (grid[tx][ty] == 1) {
          result += floodFill(grid, tx, ty);
        }
      }      
    }
    return result;
  }
        
  public int maxAreaOfIsland(int[][] grid) {
    n = grid.length;
    if (n == 0) return 0;
    m = grid[0].length;
    int result = 0;
    int temp = 0;
    
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          temp = floodFill(grid, i, j);
          if (temp > result) {
            result = temp;
          }
        }
      }
    }
    return result;
  }
}