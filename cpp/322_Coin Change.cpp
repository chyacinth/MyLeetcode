/**
 * Simple DP
 */ 
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<int> dp(amount + 1, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int coin : coins) {
                int temp = i - coin;
                if (temp >= 0 && dp[temp] >= 0)
                    dp[i] = (dp[i] == -1)?dp[temp] + 1:min(dp[i], dp[temp] + 1);
            }
        }
        return dp[amount];
    }
};