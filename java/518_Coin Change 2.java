/**
 * simple DP
 */
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        //dp[i,j] = dp[i - coins[j], j - 1] + dp[i, j - 1];
        for (int j = 0; j < coins.length; ++j) {
            for (int i = 0; i <= amount; ++i) {
                if (i - coins[j] >= 0) {
                    dp[i] += dp[i - coins[j]];
                }
            }
        }
        return dp[amount];
    }
}