/**
 * 碰到数组题一定要想到双指针，特别是有数组和的那种题。
 */
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 2; i < nums.length; ++i) {
            int l = 0;
            int r = i - 1;            
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    result += r - l;
                    --r;
                } else {
                    ++l;
                }
            }
        }
        return result;
    }
}