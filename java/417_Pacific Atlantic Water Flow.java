/**
 * BFS
 */
class Solution {
    private final int[] dx = new int[] {0, -1, 0, 1};
    private final int[] dy = new int[] {1, 0, -1, 0};
    private int n;
    private int m;
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        n = matrix.length;   
        if (n == 0) return result;
        m = matrix[0].length;
        if (m == 0) return result;
        boolean[][] isLeftUp = new boolean[n][m];
        boolean[][] isRightDown = new boolean[n][m];
        // id = i * m + j;
        Set added = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            int id = i * m;
            queue.offer(id);
            added.add(id);
        }
        for (int j = 0; j < m; ++j) {
            int id = j;
            queue.offer(id);
            added.add(id);
        }
        while (!queue.isEmpty()) {
            int id = queue.poll();
            int x = id / m;
            int y = id % m;
            isLeftUp[x][y] = true;
            for (int i = 0; i < 4; ++i) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                if (tx >= 0 && tx < n && ty >= 0 && ty < m &&
                   matrix[tx][ty] >= matrix[x][y]) {
                    int newId = tx * m + ty;
                    if (!added.contains(newId)) {
                        queue.offer(newId);
                        added.add(newId);
                    }
                }
            }
        }
        
        added = new HashSet<Integer>();
        queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            int id = i * m + m - 1;
            queue.offer(id);
            added.add(id);
        }
        for (int j = 0; j < m; ++j) {
            int id = (n - 1) * m + j;
            queue.offer(id);
            added.add(id);
        }
        while (!queue.isEmpty()) {
            int id = queue.poll();
            int x = id / m;
            int y = id % m;
            isRightDown[x][y] = true;
            for (int i = 0; i < 4; ++i) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                if (tx >= 0 && tx < n && ty >= 0 && ty < m &&
                   matrix[tx][ty] >= matrix[x][y]) {
                    int newId = tx * m + ty;
                    if (!added.contains(newId)) {
                        queue.offer(newId);
                        added.add(newId);
                    }
                }
            }
        }
        for (int i = 0; i < n; ++i)
        for (int j = 0; j < m; ++j)
        if (isLeftUp[i][j] && isRightDown[i][j]) {
            result.add(new int[]{i, j});            
        }
        return result;
    }
}