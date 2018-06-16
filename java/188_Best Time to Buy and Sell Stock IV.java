/*
难题。
维护global[i][j]数组表示第i天最多进行j次交易后的最大利润
维护local[i][j]数组表示第i天最多进行j次交易，且最后一次交易在第i天卖出后的最大利润，
则：
global[i][j] = max(global[i-1][j], local[i][j])
global有两种情况：
1. 第i天没有卖股票
2. 第i天卖了股票
local[i][j] = max(global[i-1][j-1]+diff, local[i-1][j]+diff)
local有两种情况：
1. i-1天买,i天卖，最大利润即为global[i-1][j-1]+diff
2. i-1天之前买,i天卖，最大利润即为local[i-1][j]+diff

证明上面两种情况的最大利润是上述值的话可以用反证法

注意数据中可能会有k很大而prices长度很小的情况，这种时候不需要二重循环，而当做可以交易任意次数做。

注意对于dp[i][j]=f(dp[i-1][j-1])的递推式，如果要节约存储第一维的话，对第二维(j)的循环需要是倒序，不然的话在算dp[j]的时候dp[j-1]其实是dp[i][j-1]不是dp[i-1][j-1]
*/
class Solution {
    public int maxProfit(int k, int[] prices) {     
        if (prices.length <= 1) return 0;
        if (k > prices.length) {
            int result = 0;
            for (int i = 1; i < prices.length; i++) {
                int tmp = prices[i] - prices[i - 1];
                if (tmp > 0) result += tmp;                
            }
            return result;
        }
        int[] global = new int[k + 1];
        int[] local = new int[k + 1];
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = k; j >= 1; j--) {
                local[j] = Math.max(global[j-1]+diff, local[j]+diff);
                global[j] = Math.max(global[j], local[j]);
            }
        }
        return global[k];
    }
}