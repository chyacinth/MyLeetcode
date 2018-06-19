//result[i] = left * right
//left and right can be maintained incrementally, with 1 parameter
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int temp = 1;
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        for (int i = 0; i < nums.length; i++) {
            result[i] *= temp;
            temp *= nums[i];
        }
        temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }
        return result;
    }
}