class Solution {
  public int longestPalindromeSubseq(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];
    for (int i = 0; i < n; ++i) {
      dp[i][i] = 1;
    }
    for (int d = 1; d < s.length(); ++d) {
      for (int i = 0; i < s.length() - d; ++i) {
        int j = i + d;
        dp[i][j] = Math.max(dp[i][j], dp[i + 1][j]);
        dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
        if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
        }
      }
    }
    return dp[0][n - 1];
  }
}