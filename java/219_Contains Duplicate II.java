/**
 * 最简单的方法是使用HashMap，但是用HashSet速度可以更快，空间也更少。做法为让Set在遍历中只维护i-k到i之间的元素
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();        
        for (int i = 0; i < nums.length; i++) {
            if (i - k > 0) {
                set.remove(nums[i - k - 1]);
            }
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
}