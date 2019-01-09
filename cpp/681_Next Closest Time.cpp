/**
 * 设有n个不同的数字。则可以把时间从小到大映射到n进制编码中。然后编码+1的n进制数再反映射回时间，验证符合时间的规范即可。
 * 注意超过24点对应的编码就要变回0。以及如果只有1个不同的数字，如00:00，那么就特殊情况处理。
 */ 
class Solution {
public:
    int timeToCode(const string& time, int base, const vector<int>& time_to_num) {
        int cnt = 1;
        int result = 0;
        for (auto ch = time.rbegin(); ch != time.rend(); ++ch) {
            if (isdigit(*ch)) {
                result += time_to_num[*ch - '0'] * cnt;
                cnt *= base;
            }
        }
        return result;
    }
    string codeToTime(int code, int base, const vector<int>& num_to_time) {
        string result;        
        while (code) {
            result += '0' + num_to_time[code % base];
            code /= base;
        }        
        result += string(4 - result.size(), '0' + num_to_time[0]);
        reverse(result.begin(), result.end());
        
        return result;
    }
    string nextClosestTime(string time) {
        vector<int> num_to_time;
        for (auto ch : time) {
            if (isdigit(ch)) {
                num_to_time.push_back(ch - '0');
            }
        }
        sort(num_to_time.begin(), num_to_time.end());
        num_to_time.erase(unique(num_to_time.begin(), num_to_time.end()),
                     num_to_time.end());
        vector<int> time_to_num(10,0);
        for (int i = 0; i < num_to_time.size(); ++i) {
            time_to_num[num_to_time[i]] = i;
        }
        int base = num_to_time.size();
        if (base == 1) {
            return time;
        }
        int code = timeToCode(time, base, time_to_num) + 1;        
        do {
            string time = codeToTime(code, base, num_to_time);
            int time_digit = stoi(time);
            if (time_digit >= 2400) {
                code = 0;
                continue;
            } else if (time_digit % 100 >= 60 || time_digit / 100 >= 24) {
                ++code;
                continue;
            } else {
                return time.substr(0,2)+":"+time.substr(2,2);
            }
        } while (true);           
        return "";
    }
};