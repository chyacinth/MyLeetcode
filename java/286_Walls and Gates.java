class Solution {
    private final int[] dx = {0, -1, 0, 1};
    private final int[] dy = {1, 0, -1, 0};
    
    public void wallsAndGates(int[][] rooms) {        
        int n = rooms.length;
        if (n == 0) { return; }
        int m = rooms[0].length;
        if (m == 0) { return; }
        // id = m * i + j        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (rooms[i][j] == 0) {
                    int id = m * i + j;
                    queue.offer(id);
                }
            }
        }
        while (!queue.isEmpty()) {
            int id = queue.poll();
            int x = id / m;
            int y = id % m;
            int val = rooms[x][y];
            for (int i = 0; i < 4; ++i) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                if (tx >= 0 && tx < n && ty >= 0 && ty < m) {
                    if (rooms[tx][ty] > val + 1) {
                        rooms[tx][ty] = val + 1;
                        int tid = m * tx + ty;
                        queue.offer(tid);                        
                    }
                }
            }
        }
    }
}