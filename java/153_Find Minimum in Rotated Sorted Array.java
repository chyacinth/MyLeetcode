/**
 * 二分查找
 */
class Solution {    
    public int findMin(int[] nums) {        
        int l = 0, r = nums.length - 1, result = nums[0], mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] >= nums[0]) {l = mid + 1;}
            else {
                result = Math.min(result, nums[mid]);
                r = mid - 1;
            }
        }
        return result;
    }
}