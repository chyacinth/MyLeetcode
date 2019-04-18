/**
 * 难题？其实不是很难。对来回整个过程做dp不好做，可以把它看成是两个从1,1到n,n的人在走。
 * 需要状态压缩，见https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-741-cherry-pickup/
 **/ 
class Solution {
public:
    int cherryPickup(vector<vector<int>>& grid) {
        int n = grid.size();        
        vector<vector<vector<int>>> dp(2 * n - 1, vector<vector<int>>(n, vector<int>(n)));
        vector<vector<char>> reachable(n, vector<char>(n));
        dp[0][0][0] = grid[0][0];
        reachable[0][0] = true;
        for (int i = 1; i < 2 * n - 1; ++i) {
            for (int x1 = max(0, i - n + 1); x1 <= min(i, n - 1); ++x1) {
                for (int x2 = max(0, i - n + 1); x2 <= min(i, n - 1); ++x2) {
                    int y1 = i - x1;
                    int y2 = i - x2;
                    //cout << x1 << " " << x2 << " " << y1 << " " << y2 << endl;
                    if (grid[x1][y1] != -1 && grid[x2][y2] != -1) {
                        int cherry = (x1 == x2 && y1 == y2)?grid[x1][y1] : (grid[x1][y1] + grid[x2][y2]);
                        for (int j = 0; j < 4; ++j) {
                            int o_x1 = x1 + dx1[j];
                            int o_x2 = x2 + dx2[j];
                            int o_y1 = y1 + dy1[j];
                            int o_y2 = y2 + dy2[j];
                            if (o_x1 >= 0 && o_x1 < n && o_x2 >= 0 && o_x2 < n &&
                            o_y1 >= 0 && o_y1 < n && o_y2 >= 0 && o_y2 < n && 
                            grid[o_x1][o_y1] != -1 && grid[o_x2][o_y2] != -1 && 
                            reachable[o_x1][o_y1] && reachable[o_x2][o_y2]) {
                                //cout << o_x1 << " " << o_y1 << " " << o_x2 << " " << o_y2 << endl;
                                //cout << x1 << " " << x2 << endl;
                                dp[i][x1][x2] = max(dp[i][x1][x2], cherry + dp[i-1][o_x1][o_x2]);
                                reachable[x1][y1] = true;
                                reachable[x2][y2] = true;
                            }
                        }
                    }
                }
            }
        }
        return dp[2 * n - 2][n - 1][n - 1];
    }
private:
    const array<int, 4> dx1 {-1, 0, -1, 0};
    const array<int, 4> dy1 {0, -1, 0, -1};
    const array<int, 4> dx2 {-1, -1, 0, 0};
    const array<int, 4> dy2 {0, 0, -1, -1};
};