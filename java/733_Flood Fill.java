class Solution {
    private final int[] dx = new int[]{0, -1, 0, 1};
    private final int[] dy = new int[]{1, 0, -1, 0};
    boolean[][] visited;
    int n;
    int m;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        n = image.length;
        m = image[0].length;
        visited = new boolean[n][m];
        floodFillHelper(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    private void floodFillHelper(int[][] image, int x, int y, int oldColor, int newColor) {
        visited[x][y] = true;
        image[x][y] = newColor;
        for (int i = 0; i < 4; ++i) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (tx >= 0 && tx < n && ty >= 0 && ty < m && !visited[tx][ty] && image[tx][ty] == oldColor) {
                floodFillHelper(image, tx, ty, oldColor, newColor);
            }
        }
    }
}