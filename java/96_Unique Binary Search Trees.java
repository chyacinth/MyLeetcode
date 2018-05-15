/*
简单dp
总方案数 = sum(选定根节点后左子树方案数*右子树方案数)
*/
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        int result = 0;
        dp[0] = 1;
        dp[1] = 1;        
        for (int i = 2; i <= n; i++) {
            result = 0;
            for (int j = 1; j <= i; j++) {
                int left = dp[j - 1];
                int right = dp[i - j];
                result += left * right;
            }
            dp[i] = result;
        }
        return dp[n];
    }
}