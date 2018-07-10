/**
 * 二分
 * 注意target大于所有数的情况
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        int res = -1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] > target) {
                res = mid;
                r = mid - 1;
            }
            else if (nums[mid] < target) {
                l = mid + 1;
            }
            else {
                return mid;
            }
        }
        if (res < 0) { res = nums.length;}
        return res;
    }
}