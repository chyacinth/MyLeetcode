/**
 * Let the list be:
 * a0, a1, a2, ..., ak, ..., a2k, ...
 * mark each a_n*k as a pillar
 * maintain max_left[i] = the maximum from left nearest pillar to i
 * maintain max_right[i] = the maximum from right nearest pillar to i
 * then result[i] = max(max_right[i], max_left[i+k-1])
 **/ 

class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        // max value from left(pillar) to right at each segment of k nums
        int maximum = 0;
        if (nums.empty()) {
            return vector<int>();
        }
        vector<int> max_left(nums.size());
        for (int i = 0; i < nums.size(); ++i) {
            if (i % k == 0) {
                maximum = nums[i];                
            } else {
                maximum = max(maximum, nums[i]);
            }
            max_left[i] = maximum;
        }
        
        // max value from right(pillar) to left at each segment of k nums
        maximum = 0;
        vector<int> max_right(nums.size());
        for (int i = nums.size() - 1; i >= 0; --i) {
            if (i % k == 0) {
                maximum = nums[i];                
            } else {
                maximum = max(maximum, nums[i]);
            }
            max_right[i] = maximum;
        }
        
        vector<int> result(nums.size() - k + 1);
        // overall max
        for (int i = 0; i < nums.size() && i + k - 1 < nums.size(); ++i) {            
            result[i] = max(max_right[i], max_left[i + k - 1]);
        }                
        
        return result;
    }
};