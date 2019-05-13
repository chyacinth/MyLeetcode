/**
 * 简单bfs
 **/ 
class Solution {
public:
  int snakesAndLadders(vector<vector<int>>& board) {
    int n = board.size();
    unordered_map<int, int> ladder;
    int id = 0;    
    for (int i = n - 1; i >= 0; --i) {            
      if ((n - 1 - i) % 2 == 1) {
        for (int j = n - 1; j >= 0; --j) {
          ++id;
          if (board[i][j] != -1) {          
            ladder[id] = board[i][j];
          }
        }
      } else {
        for (int j = 0; j < n; ++j) {
          ++id;
          if (board[i][j] != -1) {          
            ladder[id] = board[i][j];
          }
        }
      }
    }
    vector<char> record(n * n + 1);
    // [ [id, step] ]
    queue<pair<int, int>> bfs;    
    bfs.push({1, 0});
    record[0] = true;    
    while (!bfs.empty()) {      
      auto [id, step] = bfs.front();
      //cout << id << endl;
      if (id == n * n) {
        return step;
      }
      bfs.pop();            
      for (int i = 1; i <= 6; ++i) {
        if (id + i <= n * n) {
          if (ladder.find(id + i) != ladder.end() && !record[ladder[id + i]]) {            
            record[ladder[id + i]] = true;
            bfs.push({ladder[id + i], step + 1});
          } else if (ladder.find(id + i) == ladder.end() && !record[id + i]) {
            record[id + i] = true;
            bfs.push({id + i, step + 1});
          }
        }
      }
    }
    return -1;
  }
};