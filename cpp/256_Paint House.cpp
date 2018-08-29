/**
 * Very easy DP
 */  
class Solution {
public:
  int minCost(vector<vector<int>>& costs) {
    int n = costs.size();
    if (n == 0) return 0;
    int m = costs[0].size();
    if (m == 0) return 0;
    vector<vector<int>> dp(n + 1,vector<int>(3));
    dp[0][0] = 0;
    dp[0][1] = 0;
    dp[0][2] = 0;
    for (int i = 1; i <= n; ++i) {
      dp[i][0] = min({dp[i - 1][1], dp[i - 1][2]}) + costs[i - 1][0];
      dp[i][1] = min({dp[i - 1][0], dp[i - 1][2]}) + costs[i - 1][1];
      dp[i][2] = min({dp[i - 1][0], dp[i - 1][1]}) + costs[i - 1][2];
    }
    return min({dp[n][0],dp[n][1],dp[n][2]});
  }
};