//floodfill
class Solution {
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    int n = 0, m = 0;    
    void dfs(int x, int y, char[][] grid) {
        grid[x][y] = '-';
        for (int i = 0; i < 4; i++) {
            if (x + dx[i] >= 0 && x + dx[i] < n && y + dy[i] >= 0 && y + dy[i] < m && (grid[x + dx[i]][y + dy[i]] == '1')) {
                dfs(x + dx[i], y + dy[i], grid);
            }
        }
    }
    public int numIslands(char[][] grid) {
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        if (m == 0) return 0;        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {                
                if (grid[i][j] == '1') {
                    cnt += 1;
                    dfs(i,j,grid);
                }
            }
        }
        return cnt;
    }
}