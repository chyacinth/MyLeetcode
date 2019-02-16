/*
    很多特殊情况，需要仔细考虑。思路见:
    It just construct 3 Palindromes, first is mirror the fist half to the last, second is let first half plus one and mirror to the last, third is let firs half minus one and mirror to the last. Then compare the three and return the nearest.
*/
class Solution {
public:
    string nearestPalindromic(string n) {        
        if (n.size() == 1) {
            if (n == "0") return "1";
            else return to_string(stol(n) - 1);
        }        
        long nnum = stol(n);
        int sz = n.size();        
        
        long result_long = 0;
        long diff = numeric_limits<long>::max();
        
        // flip the first part        
        string first(n.substr(0, (sz + 1) / 2));
        long t = stol(first);
        string second = first;
        std::reverse(second.begin(), second.end());
        string str = first;
        if (sz % 2 == 1 ) str.pop_back();
        str += second;
        if (str != n) {
            long t = stol(str);            
            if ((abs(t - nnum) < diff) || (abs(t - nnum) == diff && t < result_long)) {
                diff = abs(t - nnum);
                result_long = t;
            }
        }
        
        // add the first part by one, flip
        first = to_string(stol(first) + 1);
        t = stol(first);
        second = first;        
        str = first;
        //cout << "t: " << t;
        if (sz % 2 == 1) {
            str.pop_back();
        }
        if (to_string(t-1).size() != to_string(t).size()) second.pop_back();
        std::reverse(second.begin(), second.end());
        str += second;
        if (str != n) {
            long t = stol(str);            
            if (abs(t - nnum) < diff || (abs(t - nnum) == diff && t < result_long)) {
                diff = abs(t - nnum);
                result_long = t;
            }
        }
        
        // minus the first part by one, flip        
        if (long t = stol(first) - 2; t > 0) {
            first = to_string(t);
            second = first;
            std::reverse(second.begin(), second.end());
            str = first;
            if (sz % 2 == 1) {
                str.pop_back();
            } 
            if (to_string(t+1).size() != to_string(t).size()) {
                str.push_back('9');
            }
            str += second;
            if (str != n) {
                long t = stol(str);                
                if (abs(t - nnum) < diff || (abs(t - nnum) == diff && t < result_long)) {
                    diff = abs(t - nnum);
                    result_long = t;
                }
            }
        } else {
            if (abs(9 - nnum) < diff || (abs(9 - nnum) == diff && 9 < result_long)) {
                diff = abs(9 - nnum);
                result_long = 9;
            }
        }
                
        return to_string(result_long);
    }
};