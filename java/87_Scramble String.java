/*
动归or递归都可以
s1和s2为scramble = s1和s2在同一点分割后的子串为scramble或s1和s2在对称点分割后的子串为scramble
*/
class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n == 0 || n != m) {return false;}
        boolean[][][] dp = new boolean[n][n][n+1];
        for (int len = 0; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (len > Math.min(n - i, n - j)) continue;
                    if (len == 0) dp[i][j][len] = true;
                    else if (len == 1){
                        if (s1.charAt(i) == s2.charAt(j)) dp[i][j][len] = true;                        
                    }
                    else {                                                
                        for (int k = 1; k < len; k++){
                            if ((dp[i][j + len - k][k] && dp[i+k][j][len - k]) || (dp[i][j][k] && dp[i+k][j+k][len - k])) {
                                dp[i][j][len] = true;
                                break;
                            }
                        }
                    }                    
                }
            }
        }
        return dp[0][0][n];
    }
}