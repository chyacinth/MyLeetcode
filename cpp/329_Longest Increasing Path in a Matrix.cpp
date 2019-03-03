/**
 * 我用的bfs，但最好要用dfs
 * 见https://leetcode.com/problems/longest-increasing-path-in-a-matrix/solution/
 * It depends upon where do you most likely expect your solution node to be. Mostly in the neighborhood of your current node ?  -> choose BFS
    Mostly likely the farthest descendant of a node ? -> choose DFS
    一般问最长的话，如果要用搜索还是dfs好。
 */ 
class Solution {
public:
    inline string getStr(const pair<int, int> &p) {
        return to_string(p.first) + "_"s + to_string(p.second);
    }
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        int n = matrix.size();
        if (n == 0) {
            return 0;
        }        
        int m = matrix[0].size();
        if (m == 0) {
            return 0;
        }
        vector<vector<int>> dp(n, vector<int>(m));
        queue<pair<int, int>> bfs;
        unordered_set<string> in_queue;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                bool is_start = true;
                for (int k = 0; k < 4; ++k) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && x < n && y >= 0 && y < m) {
                        if (matrix[x][y] < matrix[i][j]) {
                            is_start = false;
                        }
                    }
                }
                if (is_start) {
                    bfs.push({i, j});
                    in_queue.insert(getStr({i, j}));
                }
            }
        }        
        int result = 0;
        while (!bfs.empty()) {
            auto [i, j] =  bfs.front();
            result = max(dp[i][j], result);
            bfs.pop();
            in_queue.erase(getStr({i, j}));
            for (int k = 0; k < 4; ++k) {
                
                int x = i + dx[k];
                int y = j + dy[k];
                if (x >= 0 && x < n && y >= 0 && y < m) {
                    if (matrix[x][y] > matrix[i][j] && dp[x][y] < dp[i][j] + 1) {
                        dp[x][y] = dp[i][j] + 1;
                        if (in_queue.find(getStr({x, y})) == in_queue.end()) {
                            bfs.push({x, y});
                            in_queue.insert(getStr({x, y}));
                        }
                    }
                }            
            }
        }
        return result + 1;
    }
private:
    int dx[4] = {0, -1, 0, 1};
    int dy[4] = {-1, 0, 1, 0};
};