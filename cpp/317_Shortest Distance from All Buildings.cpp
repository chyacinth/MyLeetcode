/**
 * 找每个建筑物到周围点的距离，然后加起来
 **/ 
class Solution {
public:
    int shortestDistance(vector<vector<int>>& grid) {        
        int n = grid.size();
        int m = grid[0].size();
        int dx[4] = {0, -1, 0, 1};
        int dy[4] = {1, 0, -1, 0};
        int visited_buildings = 0;
        auto total = vector<vector<int>>(n, vector<int>(m));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    queue<pair<pair<int, int>, int>> bfs;
                    bfs.emplace(make_pair(i, j), 0);
                    while (!bfs.empty()) {
                        auto [point, dist] = bfs.front();
                        bfs.pop();
                        for (int i = 0; i < 4; ++i) {                            
                            int nx = point.first + dx[i];
                            int ny = point.second + dy[i];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == -visited_buildings) {
                                --grid[nx][ny];
                                total[nx][ny] += dist + 1;
                                bfs.emplace(make_pair(nx, ny), dist + 1);
                            }
                        }
                    }
                    ++visited_buildings;                    
                }
            }
        }
        int ans = numeric_limits<int>::max();
        bool found_sol = false;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                //cout << total[i][j] << " ";
                if (grid[i][j] == -visited_buildings) {
                    found_sol = true;
                    ans = min(ans, total[i][j]);
                }
            }
            //cout << endl;
        }
        if (!found_sol) return -1;
        return ans;
    }
};