class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {                
                if (i - 1 >= 0) dp[i][j] = dp[i - 1][j] + grid[i][j];
                if (j - 1 >= 0) {
                    if (dp[i][j] == 0) {dp[i][j] = dp[i][j - 1] + grid[i][j];}
                    else {dp[i][j] = Math.min(dp[i][j - 1] + grid[i][j], dp[i][j]);};
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}