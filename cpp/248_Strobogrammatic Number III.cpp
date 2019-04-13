/**
 * 难题，相当难。和回文数一样枚举一半。且每一位必须是0,1,6,8,9中的一个，所以用5进制数。进行映射。然后需要找到最小的可能数和最大的可能数。可以用二分法。
 * 最外层一个循环是此次枚举的字符串的长度len。然后通过计算得出枚举的范围。对于这个范围内的数用二分法找出最小的方案和最大的方案，映射到5进制后他们之差就是此次的方案数
 * 注意字符串长度是奇数的时候，当中的那个数（枚举一半时的最后一个数）必须是0,1,8，因此需要固定这个数三次，并枚举前len/2个数。
 **/ 
class Solution {
public:
    string from_id(int id, int len, bool is_odd) {
        string result;
        for (int i = 0; i < (len + 1) / 2; ++i) {
            if (i == 0 && is_odd) {
                result = stro[id % 5];
            } else {
                result = stro[id % 5] + result + stro[rev[id % 5]];
            }
            id = id / 5;
        }
        return result;
    }
    int search_leq(int min_id, int max_id, const string& str, int add = 0) {
        int l = min_id;
        int r = max_id;
        int len = str.size();
        int result = -1;
        bool is_odd = str.size() % 2;
        while (l <= r) {
            int mid = (l + r) / 2;            
            string stro_str;
            //cout << len << endl;
            if (is_odd) { stro_str = from_id(mid * 5 + add, len, is_odd); }
            else { stro_str = from_id(mid, len, is_odd); }
            //cout << "mid: " << mid << " from_id: " << stro_str << endl;
            if (stro_str > str) {
                r = mid - 1;
                result = mid;
            } else if (stro_str < str) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        //cout << "result: "<< result << endl;
        return result;
    }
    int search_seq(int min_id, int max_id, const string& str, int add = 0) {
        int l = min_id;
        int r = max_id;
        int len = str.size();
        int result = -1;
        bool is_odd = str.size() % 2;
        while (l <= r) {
            int mid = (l + r) / 2;
            string stro_str;
            if (is_odd) { stro_str = from_id(mid * 5 + add, len, is_odd); }
            else { stro_str = from_id(mid, len, is_odd); }
            //cout << "mid: " << mid << " from_id: " << stro_str << endl;
            if (stro_str > str) {
                r = mid - 1;                
            } else if (stro_str < str) {
                l = mid + 1;
                result = mid;
            } else {
                return mid;
            }
        }
        //cout << "result: "<< result << endl;
        return result;
    }
    
    int count_number(const string& low, const string& high) {
        //cout << "low: " << low << " high: " << high << endl; 
        int len = low.size();
        int result = 0;        
        
        int min_range = pow(5, len / 2 - 1);
        int max_range = pow(5, len / 2) - 1;
        
        if (len == 1) {
            min_range = 0;
            max_range = 0;
        };
        //cout << "min_id: " << min_id << " max_id: " << max_id << endl;
        if (len % 2 == 1) {
            int min_id = search_leq(min_range, max_range, low, 0);
            int max_id = search_seq(min_range, max_range, high, 0);
            if (min(min_id, max_id) >= min_range && max(min_id, max_id) <= max_range) {
                result += max_id - min_id + 1;
            }
            
            min_id = search_leq(min_range, max_range, low, 1);
            max_id = search_seq(min_range, max_range, high, 1);
            if (min(min_id, max_id) >= min_range && max(min_id, max_id) <= max_range) {
                result += max_id - min_id + 1;
            }
            
            min_id = search_leq(min_range, max_range, low, 3);
            max_id = search_seq(min_range, max_range, high, 3);
            if (min(min_id, max_id) >= min_range && max(min_id, max_id) <= max_range) {
                result += max_id - min_id + 1;
            }
        } else {                        
            int min_id = search_leq(min_range, max_range, low, 0);
            int max_id = search_seq(min_range, max_range, high, 0);
            if (min(min_id, max_id) >= min_range && max(min_id, max_id) <= max_range) {
                result += max_id - min_id + 1;
            }
        }
        return result;
    }

    int strobogrammaticInRange(string low, string high) {        
        int result = 0;
        for (int len = low.size(); len <= high.size(); ++len) {
            string t_low;
            string t_high;
            if (len == low.size()) {
                t_low = low;
            } else {
                t_low = string(len, '0');
                t_low[0] = '1';
            }
            if (len == high.size()) {
                t_high = high;
            } else {
                t_high = string(len, '9');                
            }
            result += count_number(t_low, t_high);
        }
        return result;
    }
private:
    const array<string, 5> stro = {"0", "1", "6", "8", "9"};
    const array<int, 5> rev = {0, 1, 4, 3, 2};
};