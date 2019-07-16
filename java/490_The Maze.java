/**
 * 简单dfs
 */
class Solution {
    
    private int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    private boolean dfs(int[][] maze, int[] start, int[] dest) {
        boolean result = false;
        if (start[0] == dest[0] && start[1] == dest[1]) {
            return true;
        }
        maze[start[0]][start[1]] = 2;
        for (int i = 0; i < 4; ++i) {
            int x = start[0];
            int y = start[1];
            do {
                x += d[i][0];
                y += d[i][1];
            } while (
                x >= 0 && x < maze.length && 
                y >= 0 && y < maze[0].length &&
                maze[x][y] != 1
            );
            x -= d[i][0];
            y -= d[i][1];
            if (maze[x][y] == 0) {
                result |= dfs(maze, new int[]{x, y}, dest);
            }
            if (result) {return result;}
        }
        return result;
    }
    
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        if (maze.length == 0 || maze[0].length == 0) {
            return false;
        }
        int n = maze.length;
        return dfs(maze, start, dest);
    }
}