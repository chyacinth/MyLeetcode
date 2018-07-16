/**
 * 当车从i-1处出发，绕圈过程中在j处产生的最小值记为min{i-1,j}，则当车从i处出发，绕圈过程中产生的最小值为
 * min{i,j}，则min{i,j} = min{i-1,j} - min{i-1,i-1}。因此车从i-1处出发，整个绕圈过程中产生的最小值为min{i-1}，
 * 则min{i-1} - min{i-1,i-1} = min{i,j}
 * 还有一个情况没有考虑，那就是当车绕完一圈后油量也需要大于等于0
 * 考虑上述两点都满足的情况下就可以返回i
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int lowest = gas[0] - cost[0];
        int temp = 0;
        for (int i = 0; i < gas.length; ++i) {
            temp += gas[i] - cost[i];
            if (lowest > temp) { lowest = temp; }
        }
        int global = temp;
        if (lowest >= 0) return 0;
        for (int i = 1; i < gas.length; ++i) {
            lowest = lowest - (gas[i - 1] - cost[i - 1]);
            if (lowest >= 0 && global >= 0) return i;
        }
        return -1;
    }
}