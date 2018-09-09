class TicTacToe {
public:  
  /** Initialize your data structure here. */
  TicTacToe(int n) {
    n_ = n;
    black_row_counter_.resize(n);
    black_col_counter_.resize(n);        
    white_row_counter_.resize(n);
    white_col_counter_.resize(n);    
  }
    
  /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
  int move(int row, int col, int player) {
    if (player == 1) {
      if (++black_row_counter_[row] == n_) { return player; }      
      if (++black_col_counter_[col] == n_) { return player; }
      if (row == col) {
        if (++black_left_diag_counter_ == n_) { return player; }      
      }
      if (row + col == n_ - 1) {
        if (++black_right_diag_counter_ == n_) { return player; }
      }
    } else {
      if (++white_row_counter_[row] == n_) { return player; }
      if (++white_col_counter_[col] == n_) { return player; }
      if (row == col) {
        if (++white_left_diag_counter_ == n_) { return player; }
      }
      if (row + col == n_ - 1) {
        if (++white_right_diag_counter_ == n_) { return player; }
      }
    }    
    return 0;
  }
private:
  int n_ = 0;
  vector<int> black_row_counter_;
  vector<int> white_row_counter_;
  vector<int> black_col_counter_;
  vector<int> white_col_counter_;
  int black_left_diag_counter_ = 0;
  int white_left_diag_counter_ = 0;
  int black_right_diag_counter_ = 0;
  int white_right_diag_counter_ = 0;
};

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */