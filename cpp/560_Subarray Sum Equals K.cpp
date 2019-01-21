/**
 * sum[i,j] = sum[j] - sum[i];
 * so sum[i,j] = k exists <==> sum[i] = sum[j] - k exists
 * We use a map to indicate the frequency of prefix sum. Then when we get sum[j],
 * we can use sum[j] - k to check whether sum[i] exists and add its frequency.
 */ 
class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> sums;
        sums.insert({0, 1});
        int sum = 0;
        int result = 0;
        for (int num : nums) {
            sum += num;
            if (sums.find(sum - k) != sums.end()) {
                result += sums[sum - k];
            }            
            ++sums[sum];
        }
        return result;
    }
};