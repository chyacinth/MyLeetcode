/**
 * ……dp
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];
        int n = cost.length;
        int cost1 = 0;
        int cost2 = 0;
        int cost3 = 0;
        for (int i = 2; i <= n; ++i) {
            cost3 = Math.min(cost1 + cost[i - 2], cost2 + cost[i - 1]);
            cost1 = cost2;
            cost2 = cost3;
        }
        return cost3;
    }
}