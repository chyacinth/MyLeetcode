class Solution {
public:
    void explore(vector<vector<char>>& board, int n, int m, int x, int y) {
        int adjacent_mine = 0;        
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                if (x + i >= 0 && x + i < n && 
                    y + j >= 0 && y + j < m) {
                    adjacent_mine += (board[x + i][y + j] == 'M');
                }
            }
        }
        if (adjacent_mine > 0) {
            board[x][y] = '0' + adjacent_mine;
        } else {
            board[x][y] = 'B';
            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) {
                    if (x + i >= 0 && x + i < n && 
                    y + j >= 0 && y + j < m) {
                        if (board[x + i][y + j] == 'E') {
                            board[x + i][y + j] = 'B';
                            explore(board, n, m, x + i, y + j);
                        }
                    }
                }
            }
        }
        return;
        
    }
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        int x = click[0];
        int y = click[1];
        int n = board.size();
        if (n == 0) {
            return board;
        }
        int m = board[0].size();
        if (m == 0) {
            return board;
        }
        if (x >= 0 && x < n && y >= 0 && y < m) {
            if (board[x][y] == 'M') {
                board[x][y] = 'X';
            } else if (board[x][y] == 'E') {
                explore(board, n, m, x, y);
            }
        }
        return board;
    }
};