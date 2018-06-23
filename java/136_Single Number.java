/*
卧槽，居然是位运算，根本没想到！！
从第一个到最后一个元素全部xor起来即可
*/
class Solution {
    public int singleNumber(int[] nums) {        
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}