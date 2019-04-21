/**
 * 简单模拟
 **/ 
class Solution {
public:
  bool check_and_remove(vector<vector<int>>& board) {
    bool found = false;
    for (int i = 0; i < board.size(); ++i) {
      for (int j = 0; j < board[0].size(); ++j) {
        if (board[i][j] == 0) continue;
        if (i - 2 >= 0) {          
          if (abs(board[i - 2][j]) == abs(board[i - 1][j]) && abs(board[i - 1][j]) == abs(board[i][j])) {
            found = true;
            int value = abs(board[i - 2][j]);
            board[i - 2][j] = -value;
            board[i - 1][j] = -value;
            board[i][j] = -value;
          }
        }
        if (j - 2 >= 0) {          
          if (abs(board[i][j - 2]) == abs(board[i][j - 1]) && abs(board[i][j - 1]) == abs(board[i][j])) {
            found = true;
            int value = abs(board[i][j - 2]);
            board[i][j - 2] = -value;
            board[i][j - 1] = -value;
            board[i][j] = -value;
          }
        }
      }
    }
    return found;
  }
void drop_down(vector<vector<int>>& board) {
  for (int j = 0; j < board[0].size(); ++j) {
    int first = board.size() - 1;    
    int second = first;
    while (first >= 0 && second >= 0) {
      while (second >= 0 && board[second][j] <= 0) {
        --second;
      }
      if (second >= 0) {
        board[first][j] = board[second][j];
        --first;
        --second;
      }
    }    
    while (first >= 0) {
      board[first][j] = 0;
      --first;
    }
  }
}
  vector<vector<int>> candyCrush(vector<vector<int>>& board) {    
    while (check_and_remove(board)) {
      drop_down(board);
    }
    return board;
  }
};