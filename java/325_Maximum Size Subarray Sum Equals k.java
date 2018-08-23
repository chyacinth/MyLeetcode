/**
 * Improve the O(N^2) algorithm：Use HashMap to recode the partial sum: 
 * sum[i] = num[0] + ... + num[i], and its first occurence location.
 * Then traverse the array in a for loop, in each iteration i, we find the maximum
 * size subarray sum equals k ending with num[i]. So how to find it? We simply need to 
 * check wheterh k - sum[i] exists in HashMap, and its length is simply i - map[k - sum[i]]
 * 对O(N^2)算法作出改进：使用哈希表map记录部分和sum[i] = num[0]+...+num[i]，以及它首次出现的位置
 * 然后每次循环中，找以num[i]为结尾的最大子数组，即k - sum[i]在哈希表中存在，则长度为i - map[k-sum[i]]
 * 
 */
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int delta = 0;
        int result = 0;        
        for (int i = 0; i < nums.length; ++i) {            
            if (map.get(k - delta - nums[i]) != null) {
                result = Math.max(result, i - map.get(k - delta - nums[i]) + 1);
            }
            delta += nums[i];
            if (result == 0 && nums[i] == k) { result = 1; }
            if (map.get(nums[i] - delta) == null) {
                map.put(nums[i] - delta, i);
            }
        }
        return result;
    }
}