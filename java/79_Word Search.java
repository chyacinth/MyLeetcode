/*
dfs
其中怎样保证每次dfs完后board数组恢复原样（在dfs中有些字符会变成'.'以记录是否访问过）是一个问题
*/
class Solution {
    int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public boolean dfs(char[][] board, String word, int pos, int x, int y) {        
        if (board[x][y] != word.charAt(pos)) {return false;}
        if (pos >= word.length() - 1) {
            return true;
        }
        char tmp = board[x][y];
        board[x][y] = '.';
        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i], ty = y + dy[i];
            if (0 <= tx && tx < board.length && 0 <= ty && ty < board[0].length && board[tx][ty] != '.') {                
                boolean result = dfs(board, word, pos + 1, tx, ty);                
                if (result == true) {
                    board[x][y] = tmp;
                    return true;
                }
            }            
        }
        board[x][y] = tmp;
        return false;
        
    }
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        if (board[0].length == 0) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, i, j) == true) return true;
            }
        }
        return false;
    }
}