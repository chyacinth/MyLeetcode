class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 1) { return false; }
        boolean[][] dp = new boolean[2][201];
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= 200; ++j) {
                dp[i%2][j] = false;
            }
            for (int j = 0; j <= 200; ++j) {                
                if (dp[(i-1)%2][j] == true) {
                    if (j + nums[i] <= 200) {
                        dp[i%2][j + nums[i]] = true;
                    }
                    dp[i%2][Math.abs(j - nums[i])] = true;
                }
            }
        }
        return dp[(n-1)%2][0];
    }
}