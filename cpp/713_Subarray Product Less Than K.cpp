/**
 * 双指针，见hint。另外要注意 nums 0..i 和 nums 0..i+1的关系
 */ 
class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        int i = 0, j = 0;
        int mult = 1;
        int ans = 0;
        for (int j = 0; j < nums.size(); ++j) {
            mult *= nums[j];
            while (mult >= k && i <= j) {
                mult = mult / nums[i];
                ++i;
            }
            if (i <= j) {
                ans += j - i + 1;
            }
        }
        return ans;
    }
};