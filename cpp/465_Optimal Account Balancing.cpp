/**
 * 难题。唯一能理解的做法。见https://www.jiuzhang.com/article/mPaUGB/
 * 需要证明为什么没有子集的情况下结果是n-1。因为a交易给b钱，如果b不是唯一一个不交易的，那么势必b和另一个
 * 不交易的不在一组。所以
 **/ 
class Solution {
public:  
  int minTransfers(vector<vector<int>>& transactions) {
    unordered_map<int, int> flow_id;
    for (auto& tran : transactions) {
      flow_id[tran[0]] -= tran[2];
      flow_id[tran[1]] += tran[2];
    }
    vector<int> flows;
    for (auto& [id, flow] : flow_id) {
      if (flow != 0) {
        flows.push_back(flow);
      }
    }
    int n = flows.size();
    if (n == 0) return 0;
    vector<int> dp((1 << n), -1);
    for (int i = 0; i < dp.size(); ++i) {
      int sum = 0;
      int cnt = 0;
      for (int j = 0; (1 << j) <= i; ++j) {        
        if (((1 << j) & i) != 0) {          
          sum += flows[j];
          ++cnt;
        }        
      }
      if (sum == 0) {
        dp[i] = cnt - 1;
        for (int j = 1; j < i; ++j) {
          if ((i & j) == j && dp[j] >= 0 && dp[i - j] >= 0 && dp[j] + dp[i - j] < dp[i]) {
            dp[i] = dp[j] + dp[i - j];
          }
        }
      }
    }
    return dp[dp.size() - 1];    
  }
};