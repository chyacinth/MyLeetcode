/**
 * DP二元组，记录dp[i][j]表示S[i]包括S[i]左侧最近元素S[k]，作为T[j]时，k的值和子串的长度
 * dp[i][j] = {i, dp[i-1][j-1].second + i - dp[i-1][j-1].first }, if S[i]==T[j]
 * dp[i][j] = dp[i-1][j] else.
 **/ 
class Solution {
public:
  using dpnode = pair<int, int>;
  bool valid(const dpnode& node) {
    return node.first < n + 1 && node.second < n + 1;
  }
  string minWindow(string S, string T) {
    n = S.size();
    m = T.size();
    // dp {loc, size}
    int min_size = n + 1;
    dpnode result{};
    vector<vector<dpnode>> dp(2, vector<dpnode>(m, {n + 1, n + 1}));
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (S[i] == T[j]) {
          if (j == 0) {
            dp[i % 2][j] = {i, 1};
          } else if (i > 0 && valid(dp[(i-1) % 2][j-1])) {
            dp[i % 2][j] = {i, dp[(i-1) % 2][j-1].second + i - dp[(i-1) % 2][j-1].first};
          } else {
            dp[i % 2][j] = {n + 1, n + 1};
          }
        } else {
          if (i != 0)
            dp[i % 2][j] = dp[(i-1) % 2][j];
        }
        if (j == m - 1 && valid(dp[i % 2][j]) && dp[i % 2][j].second< min_size) {
          result = dp[i % 2][j];
          min_size = dp[i % 2][j].second;
        }
      }
    }    
    //cout << dp[16][0].first << " " << dp[16][0].second << endl;
    if (valid(result)) {
      return S.substr(result.first - result.second + 1, result.second);
    }
    return "";
  }
private:
  int n = 0;
  int m = 0;
};