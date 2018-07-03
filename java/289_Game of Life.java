/**
 * 给的是int[][]，希望每个点能够记录前一个状态和后一个状态，因此可以将前一个状态和后一个状态的组合进行编码即可
 */
class Solution {
    final int[] dx = {-1,-1,-1,1,1,1,0,0};
    final int[] dy = {-1,0,1,-1,0,1,-1,1};
    int n = 0;
    int m = 0;
    private int next(int[][] board, int x, int y) {
        int tx = 0;
        int ty = 0;
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            tx = x + dx[i];
            ty = y + dy[i];
            if (tx >= 0 && tx < n && ty >= 0 && ty < m) {
                if (board[tx][ty] == 1 || board[tx][ty] == 2) {
                    cnt += 1;
                }
            }
        }
        if (board[x][y] == 1) {
            if (cnt < 2) return 2;
            if (cnt > 3) return 2;
            return 1;
        } else {
            if (cnt == 3) {
                return 3;
            }
            return 0;
        }        
    }
    public void gameOfLife(int[][] board) {
        n = board.length;
        if (n > 0) m = board[0].length;
        else return;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = next(board, i, j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] %= 2;
            }
        }
    }
}