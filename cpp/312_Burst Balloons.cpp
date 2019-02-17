/*
    中等难度dp题。用dp[i][j]记录炸掉i..j范围内所有气球获得的最大值。那么
    dp[i][j] = dp[i][k-1]+dp[k+1][j]+nums[i-1]*nums[k]*nums[j+1]
*/
class Solution {
public:
    int maxCoins(vector<int>& nums) {
        int len = nums.size();
        if (len == 0) return 0;
        vector<vector<int>> dp(len, vector<int>(len));        
        for (int interval = 0; interval < len; ++interval) {
            for (int i = 0; i < len; ++i) {
                int j = i + interval;
                if (j >= len) break;
                int left = (i > 0)?nums[i - 1]:1;
                int right = (j < len - 1)?nums[j + 1]:1;
                for (int k = i; k <= j; ++k) {
                    dp[i][j] = max(dp[i][j], 
                                   (k-1>=0 ? dp[i][k-1]:0)+
                                   (k+1<len ? dp[k+1][j]:0)+
                                   left*nums[k]*right);
                }
            }
        }
        return dp[0][len - 1];
    }
};