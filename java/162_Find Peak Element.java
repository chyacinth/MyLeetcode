/**
 * 二分
 * 先证明原数列必定有解，然后看当中元素，如果当中元素不是peak，则有一侧是比它高的，可以证明高的那一侧和原数列有相同
 * 的性质（最左边的元素只要比右边大和最右边的元素只要比左边小就是peak）。因此选择那一侧作为下次二分的查找的目标数列
 */
class Solution {
    public boolean isPeak(int[] nums, int x) {      
        if (x == 0) {
            return nums[x] > nums[x + 1];
        } else if (x == nums.length - 1) {
            return nums[x - 1] < nums[x];
        }
        else {
            return (nums[x - 1] < nums[x] && nums[x] > nums[x + 1]);
        }
    }
    public int findPeakElement(int[] nums) {      
        if (nums.length == 1) return 0;
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;        
            if (!isPeak(nums, mid)) {
                if (mid > 0 && nums[mid - 1] > nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                return mid;
            }
        }
        return 0;
    }
}