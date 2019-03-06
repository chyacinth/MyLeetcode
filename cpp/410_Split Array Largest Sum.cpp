/**
 * 很容易想到 n^2m 的动归。但可以在选择分割 dp[i-j,k-1] | sum 的时候使用二分法，
 * 这样就不需要遍历n，而是log n，因此变成 n logn m 的复杂度。
 * 标准答案的二分+贪心基本上面试的时候不可能想到。故不看。
 **/ 
class Solution {
public:
    int splitArray(vector<int>& nums, int m) {
        int n = nums.size();
        vector<vector<long>> dp(n, vector<long>(2, numeric_limits<long>::max()));
        vector<long> s(n);
        s[0] = nums[0];
        for (int i = 1; i < n; ++i) {            
            s[i] = s[i - 1] + nums[i];
        }
        for (int k = 1; k <= m; ++k) {
            for (int i = k - 1; i < n; ++i) {
                dp[i][k % 2] = numeric_limits<long>::max();
                if (k == 1) {
                    if (i == 0) {
                        dp[i][k % 2] = nums[i];
                    } else {
                        dp[i][k % 2] = dp[i - 1][k % 2] + nums[i];
                    }
                } else {                    
                    int l = k - 1;
                    int r = i;                    
                    while (l <= r) {
                        int mid = (l + r) / 2;                        
                        long sum = s[i] - s[mid - 1];
                        dp[i][k % 2] = min(dp[i][k % 2], max(sum, dp[mid - 1][(k + 1) % 2]));
                        if (sum > dp[mid - 1][(k + 1) % 2]) {
                            l = mid + 1;
                        } else{
                            r = mid - 1;
                        }
                    }
                }
            }
        }
        return dp[n - 1][m % 2];
    }
};