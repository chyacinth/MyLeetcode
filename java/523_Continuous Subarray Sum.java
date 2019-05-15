/**
 * 注意条件，长度>=2，所以不能直接把这次的sum加进去，要加上一次的
 */
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Set<Integer> sums = new HashSet<>();
        sums.add(0);
        int prevSum = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; ++i) {            
            curSum = (curSum + nums[i]);
            if (k != 0) { curSum %= k; }            
            if (sums.contains(curSum)) { return true; }
            sums.add(prevSum);
            prevSum = curSum;
        }
        return false;
    }
}