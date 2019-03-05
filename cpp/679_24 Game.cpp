/**
 * 略难题。简单地用回溯枚举后缀表达式，写了好久，艹
 * 注意最后的浮点数判断是否是24，不能用==24，需要用abs(x-24) < 0.000001 这种。因为浮点数运算不精确。
 **/ 
class Solution {
public:
    double calc(const double a, const double b, char op) {
        switch (op) {
            case '+' : return a + b;
            case '-' : return a - b;
            case '*' : return a * b;
            case '/' : return a / b;
        }
        return 0;
    }
    bool helper(vector<double> &nums, unordered_multimap<int, bool> &used_nums) {        
        bool all_used = true;
        for (auto &[num, used] : used_nums) {
            if (!used) {                
                all_used = false;
                nums.push_back(static_cast<double>(num));
                used = true;
                bool found = helper(nums, used_nums);
                if (found) {
                    return true;
                }
                used = false;
                nums.pop_back();                
            }
        }
        if (all_used && nums.size() == 1) {
            if (abs(nums[0] - 24) < 0.0001) {
                return true;
            } else {
                return false;
            }
        }
        if (nums.size() >= 2) {
            double op2 = nums.back();
            nums.pop_back();
            double op1 = nums.back();
            nums.pop_back();
            for (auto op : ops) {
                if (!(op2 == 0 && op == '/')) {
                    nums.push_back(calc(op1, op2, op));
                    bool found = helper(nums, used_nums);
                    if (found) {
                        return true;
                    }
                    nums.pop_back();                
                }                
            }
            nums.push_back(op1);
            nums.push_back(op2);
        }
        return false;
    }
        
    bool judgePoint24(vector<int>& nums) {
        unordered_multimap<int, bool> used_nums;
        for (auto num : nums) {
            used_nums.insert({num, false});
        }
        vector<double> temp_results;
        return helper(temp_results, used_nums);
    }
    
private:
    vector<char> ops {'+', '-', '*', '/'};
};