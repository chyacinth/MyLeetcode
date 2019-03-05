/**
 * DP + 状态压缩。注意先写出最简单的DP，然后考虑压缩状态：观察状态转移方程。
 **/ 
class Solution {
public:
    int countSubstrings(string s) 
    {
        int n = s.size();
        vector<vector<char>> dp(n, vector<char>(2));
        
        int result = 0;
        for (int d = 0; d < n; ++d) {
            for (int i = 0; i < n; ++i) {
                int j = i + d;
                int k = d % 2;
                if (j >= n) {
                    break;
                } else {
                    if (j == i) {
                        dp[i][k] = 1;
                    } else if (j == i + 1) {
                        dp[i][k] = s[i] == s[j];
                    } else {
                        dp[i][k] = (s[i] == s[j]) && dp[i + 1][k];
                    }
                    
                }
                result += dp[i][k];
            }
        }
        return result;
    }
};