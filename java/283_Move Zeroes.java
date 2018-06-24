/**
 * 维护一个insertPos来记录应该把最新的非零数放到哪里
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPos] = nums[i];
                insertPos += 1;
            }            
        }
        for (int i = insertPos; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}