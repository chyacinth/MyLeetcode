/**
 * Easy BFS
 **/ 
class Solution {
public:
    inline string hashing(vector<vector<int>>& board) {
        auto res = string(6, ' ');
        for (int i = 0; i < 6; ++i) {
            res[i] = board[i / 3][i % 3] + '0';
        }
        return res;
    }
    inline bool success(vector<vector<int>>& board) {
        return (board[0][0] == 1 && board[0][1] == 2 && board[0][2] == 3 &&
                    board[1][0] == 4 && board[1][1] == 5 && board[1][2] == 0);
    }
    int slidingPuzzle(vector<vector<int>>& board) {
        queue<pair<vector<vector<int>>, int>> bfs;
        bfs.push(make_pair(move(board), 0));
        unordered_set<string> record;
        while (!bfs.empty()) {
            auto& [curr, cnt] = bfs.front();
            string hash_val = hashing(curr);
            //cout << hash_val << endl;
            if (success(curr)) {
                return cnt;
            }            
            if (record.find(hash_val) == record.end()) {                
                record.insert(hash_val);
                int x = 0;
                int y = 0;                
                for (int i = 0; i < 6; ++i) {
                    if (curr[i / 3][i % 3] == 0) {
                        x = i / 3;
                        y = i % 3;
                        break;
                    }
                }                
                for (int i = 0; i < 4; ++i) {
                    int tx = x + dx[i];
                    int ty = y + dy[i];
                    if (tx >= 0 && tx < 2 && ty >= 0 && ty < 3) {
                        swap(curr[x][y], curr[tx][ty]);
                        bfs.push(make_pair(curr, cnt + 1));
                        swap(curr[x][y], curr[tx][ty]);
                    }
                }
                //cout << "OK" << endl;
            }
            bfs.pop();
        }
        return -1;
    }
private:
    const int dx[4] = {0,1,0,-1};
    const int dy[4] = {1,0,-1,0};
};