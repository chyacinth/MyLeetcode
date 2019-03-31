/**
 * Simple DP
 **/ 
class Solution {
public:
    int knightDialer(int N) {
        vector<vector<int>> dp(12, vector<int>(N));
        for (int i = 0; i < 12; ++i) dp[i][0] = 1;
        dp[9][0] = 0;
        dp[11][0] = 0;
        const vector<vector<int>> reach = 
            {{5, 7}, {6, 8}, {3, 7},
             {2, 8, 10}, {}, {0, 6, 10},
             {1, 5}, {0, 2}, {1, 3},
             {4, 8}, {3, 5}, {4, 6}};        
        for (int i = 1; i < N; ++i) {
            for (int k = 0; k < 12; ++k) {
                if (k == 9 || k == 11) continue;
                for (int j : reach[k]) {                    
                    dp[k][i] = (dp[k][i] + dp[j][i - 1]) % 1'000'000'007;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 12; ++i) {
            ans = (ans + dp[i][N - 1]) % 1'000'000'007;
        }
        return ans;
    }
};