/*
dp
根据nums[i]的正负用不同的状态转移方程
max_i = max 
*/
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int result;
        if (n <= 0) return 0;
        int max, min;
        max = min = result = nums[0];
        for (int i = 1; i < n; i++) {
            int tmax = max, tmin = min;
            if (nums[i] > 0) {
                max = Math.max(tmax * nums[i], nums[i]);
                min = Math.min(tmin * nums[i], nums[i]);
            }
            else {
                max = Math.max(tmin * nums[i], nums[i]);
                min = Math.min(tmax * nums[i], nums[i]);
            }
            if (result < max) result = max;
        }
        return result;
    }    
}