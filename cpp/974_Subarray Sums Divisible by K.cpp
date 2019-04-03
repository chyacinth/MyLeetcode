/**
 * 一定要记住遇到连续子序列求和的问题要怎么做！！！！
 **/ 
class Solution {
public:
    int subarraysDivByK(vector<int>& A, int K) {
        int sum = 0;
        unordered_map<int, int> mp;
        int result = 0;
        ++mp[0];
        
        for (int a : A) {
            sum = ((sum + a) % K + K) % K;
            // if mp contains sum
            if (mp.find(sum) != mp.end()) {
                result += mp[sum];
            }            
            ++mp[sum];
        }
        return result;
    }
};