/**
 * 为何要b？因为光上下左右不够，我们还需要知道在那个点上下左右。b就代表回退点，这样我们就能知道在哪个点上下左右了
 */

class Solution {
    private int n = 0;
    private int m = 0;
    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {1, 0, -1, 0};
    
    public void getIslandShape(int[][] grid, int x, int y, StringBuilder sb) {
        grid[x][y] = -1;        
        for (int i = 0; i < 4; ++i) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (tx >= 0 && tx < n && ty >= 0 && ty < m && grid[tx][ty] == 1) {
                sb.append(i + " ");
                getIslandShape(grid, tx, ty, sb);
                sb.append("b ");
            }
        }
    }
    
    public int numDistinctIslands(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        Set<String> shapes = new HashSet<String>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    StringBuilder shapeSb = new StringBuilder();
                    getIslandShape(grid, i, j, shapeSb);
                    shapes.add(shapeSb.toString());
                    System.out.println(shapeSb.toString());
                }
            }
        }
        return shapes.size();
    }
}