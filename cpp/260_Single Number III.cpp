/**
 * The last bit trick for single number with 2 different numbers existing once 
 * and all other numbers occur twice.
 */ 
class Solution {
public:
    int lastBit(int n) {
        int last_bit = 1;
        while (! (n & last_bit)) {
            last_bit = last_bit << 1;
        }
        return last_bit;
    }
    vector<int> singleNumber(vector<int>& nums) {
        int a_xor_b = 0;
        for (int &num : nums) {
            a_xor_b ^= num;
        }
        int last_bit = lastBit(a_xor_b);
        vector<int> result{0,0};
        for (int &num : nums) {
            if (num & last_bit) { result[0] ^= num; }
            else { result[1] ^= num; }
        }    
        return result;    
    }
};