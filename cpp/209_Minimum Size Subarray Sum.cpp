class Solution {
public:
    int minSubArrayLen(int s, vector<int>& nums) {
        int sum = 0;
        int len = 0;
        for (int i = 0; i < nums.size(); ++i) {            
            sum += nums[i]; 
            if (len == 0) {                 
                if (sum >= s) {
                    len = i + 1;
                } else {
                    continue;
                }
            }                        
            sum -= nums[i - len];
            while (sum - nums[i - len + 1] >= s) {
                sum -= nums[i - len + 1];
                --len;
            }
        }
        return len;
    }            
};