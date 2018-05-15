/*
simple dp
pay attention to the case where there exists '0' in the string
and also strings like '01' is not equal to '1', '01' has no corresponding decode
*/
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[] dp = new int[n];
        if (((int)s.charAt(0)) - '0' > 0)
            dp[0] = 1;
        else dp[0] = 0;
        
        for (int i = 1; i < n; i++) {
            int tmp1 = ((int)s.charAt(i)) - '0';
            int tmp2 = (int)s.charAt(i - 1) - '0';
            int tmp3 = tmp2 * 10 + tmp1;
            if (tmp1 > 0 && tmp1 <= 9) dp[i] += dp[i - 1];            
            if (tmp2 > 0 && tmp3 <= 26) {
                if (i - 2 >= 0) dp[i] += dp[i - 2];
                else dp[i] += 1;
            }
        }
        return dp[n - 1];
    }
}