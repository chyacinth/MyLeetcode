/**
 * Use sum and partial_sum, we can easily find the left sum and right
 * sum as: partial_sum and sum - num - partial_sum
 * So we succeed in solving this problem by O(N) time and O(1) space
 */ 
class Solution {
public:
    int pivotIndex(vector<int>& nums) {
      int sum = 0;
      for (int num : nums) {
        sum += num;
      }
      int partial_sum = 0;
      for (int i = 0; i < nums.size(); ++i) {
        int num = nums[i];
        if (partial_sum == sum - num - partial_sum) {
          return i;
        }
        partial_sum += num;
      }
      return -1;
    }
};