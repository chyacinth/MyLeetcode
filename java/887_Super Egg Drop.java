/**
 * 难题。很难很恶心。先写出普通的动态转移方程 dp[k][n] = min(1+max(dp[k-1][i-1], dp[k][n-i])), i=1..n
 * 光是这个就不太好想，需要自己模拟一下过程，发现能转换成子问题。
 * 然后超时，这时发现dp[k][n]对于n递增，所以dp[k-1][i-1]对i递增，dp[k][n-i]对i递减，因此再加上dp[x][0] = 0，则画出图后，可以得出：
 * 若dp[k-1][i-1] > dp[k][n-i]，那么取min的点在右边。反之则左边，符合二分法条件。所以可以用二分法省一个内部k循环
 */
class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K+2][N+2];        
        for (int j = 0; j < N+2; ++j) dp[1][j] = j;
        for (int k = 0; k < K+2; ++k) {
            dp[k][0] = 0;
            dp[k][1] = 1;
        }
        for (int k = 2; k <= K; ++k) {
            for (int n = 2; n <= N; ++n) {
                dp[k][n] = Integer.MAX_VALUE;
                int low = 1;
                int high = n;
                while (low <= high) {                    
                    int mid = (low + high) / 2;
                    int left = dp[k-1][mid-1];
                    int right = dp[k][n-mid];
                    dp[k][n] = Math.min(dp[k][n], 1 + Math.max(left, right));
                    if (left < right) { low = mid + 1; }
                    else if (left > right) { high = mid - 1; }
                    else break;
                }
            }
        }
        return dp[K][N];        
    }
}