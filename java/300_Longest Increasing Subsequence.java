/**
 * Longest Increasing Subsequence: 难，关键是O(NlogN)的算法是怎么回事？ 
 * LIS算法，证明？可以看https://blog.csdn.net/joylnwang/article/details/6766317，
 * 也可以用数学归纳法证明每次将nums[i]放入缓存区buf时，
 * 其位置就是以nums[i]结尾（或是包含num[i]）情况下的LIS中nums[i]的位置。
 * 可以反证。利用形式：buf里同一位置上的数一直在随时间递减（或不变）
 */
class Solution {
    public int firstLargerOrEqual(List<Integer> buffer, int target) {
        int l = 0;
        int r = buffer.size() - 1;
        int result = r + 1;        
        while (l <= r) {
            int mid = (l + r) / 2;
            if (buffer.get(mid) >= target) {
                result = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return result;
    }
    public int lengthOfLIS(int[] nums) {        
        if (nums.length == 0) return 0;
        List<Integer> buffer = new ArrayList<>();
        int resultLen = 1;
        buffer.add(nums[0]);
        for (int i = 1; i < nums.length; ++i) {
            int insertPos = firstLargerOrEqual(buffer, nums[i]);
            if (insertPos >= buffer.size()) {
                buffer.add(nums[i]);
            }
            else {
                buffer.set(insertPos, nums[i]);
            }
        }
        return buffer.size();
    }
}