/*
很容易的二维动归
注意：空间可以优化，一开始用二维数组，但实际上可以变成一维，因为只用到了上次循环的信息
*/
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();        
        if (m == 0) return 1;
        if (n == 0) return 0;
        int[] dp = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = Math.min(i, m - 1); j >= 0; j--) {                
                if (i == 0) {
                    if (s.charAt(i) == t.charAt(j)) dp[j] = 1;
                }
                else {
                    if (j == 0) {                        
                        if (s.charAt(i) == t.charAt(j)) dp[j] += 1;
                    }
                    else {                        
                        if (s.charAt(i) == t.charAt(j)) dp[j] += dp[j - 1];                        
                    }
                }
                if (i == n - 1) return dp[m - 1];
            }
        }
        return dp[m - 1];
    }
}