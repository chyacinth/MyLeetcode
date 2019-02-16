/*
 可以参考Solution的方法。但是那个方法不完全正确。对于乘法，他没有考虑2+2*3变成2+2*34的情况。因此我们
 需要额外记录最近的运算符号。如果是乘法，那么prev的值的更新需要特殊处理，即找到最近的那个数，然后prev
 除以那个数再乘以那个数*(10+new_digit)。
*/
class Solution {
public:
    void helper(string &est_str, long prev, long eval, char last_op, const string &ori_str, int idx, long target) {
        if (idx >= ori_str.size()) {
            if (eval == target) {
                result.push_back(est_str);
            }
            return;
        } else {            
            // add operators
            int num = ori_str[idx] - '0';
            // case *
            est_str += '*';
            est_str += ori_str[idx];            
            helper(est_str, prev * num, eval + prev * (num - 1), '*', ori_str, idx + 1, target);
            est_str.pop_back();
            est_str.pop_back();     
            // case +            
            est_str += '+';
            est_str += ori_str[idx];            
            helper(est_str, num, eval + num, '+', ori_str, idx + 1, target);            
            est_str.pop_back();
            est_str.pop_back();
            // case -            
            est_str += '-';
            est_str += ori_str[idx];            
            helper(est_str, -num, eval - num, '-', ori_str, idx + 1, target);
            est_str.pop_back();
            est_str.pop_back();


            // case no ops
            if (prev != 0) {
                est_str += ori_str[idx];
                if (last_op == '*') {
                    int mul_loc = est_str.find_last_of('*');
                    int mul = std::stoi(est_str.substr(mul_loc + 1, est_str.size() - 2 - mul_loc));
                    int new_prev = prev / mul * (10 * mul + num);
                    helper(est_str, new_prev, eval - prev +  new_prev, last_op, ori_str, idx + 1, target);
                }
                 if (last_op == '+')
                    helper(est_str, 10 * prev + num, eval + 9 * prev + num, last_op, ori_str, idx + 1, target);
                else if (last_op == '-')
                    helper(est_str, 10 * prev - num, eval + 9 * prev - num, last_op, ori_str, idx + 1, target);
                est_str.pop_back();
            }
        }
    }
    vector<string> addOperators(string num, int target) {        
        string est_str = num.substr(0, 1);
        long prev = num[0] - '0';
        helper(est_str, prev, prev, '+', num, 1, target);
        return result;
    }
private:
    vector<string> result;
};