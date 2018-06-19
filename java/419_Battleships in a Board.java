//判断一个X已经被统计过：如果他的左边或上面是X，则他所在的船被统计过
class Solution {
    public int countBattleships(char[][] board) {
        int n = board.length;
        if (n <= 0) return 0;
        int m = board[0].length;
        if (m <= 0) return 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X' && !isCounted(board, i, j)) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }
    
    public boolean isCounted(char[][] board, int x, int y) {
        if ((x - 1 >= 0 && board[x - 1][y] == 'X') || (y - 1 >= 0 && board[x][y - 1] == 'X')) {
            return true;
        }
        return false;
    }
}