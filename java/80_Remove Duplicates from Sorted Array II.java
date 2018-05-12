/*
使用cur记录结果数组的最后一位
i遍历数组，用count记录变量次数，只需要比较i和i-1，i-1不会受影响（可证明）
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        int cur = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {cnt = 1;}
            else if (nums[i] == nums[i - 1]) {cnt++;}
            if (cnt <= 2) {
                nums[cur] = nums[i];
                cur++;
            }
        }
        return cur;
    }
}