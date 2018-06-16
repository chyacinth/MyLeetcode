//维护最小值
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int min = prices[0];
        int result = 0;
        int tmp;
        for (int i = 0; i < prices.length; i++) {
            tmp = prices[i];
            if (tmp - min > result) result = tmp - min;
            if (tmp < min) min = tmp;
        }
        return result;
    }
}