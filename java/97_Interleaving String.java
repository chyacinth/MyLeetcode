/*
简单二维动归，最原始是三维动归，但很容易化简
*/
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length();
        if ((n == 0 && !s2.equals(s3)) || (m == 0 && !s1.equals(s3))) {return false;}
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        if (n + m != s3.length()) {return false;}
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {                                                
                if (i - 1 >= 0)
                    dp[i][j] |= (dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1)));
                if (j - 1 >= 0)
                    dp[i][j] |= (dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1)));
            }
        }
        return dp[n][m];
    }
}