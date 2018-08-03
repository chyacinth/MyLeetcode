class Solution {
public:
    string convert(string s, int numRows) {
        int st = 1, cur = 1, n = s.length(), next1 = 0, next2 = 0, i = 0;
        string res(s.length(),'_');
        if (numRows == 1) return s;
        ++i;
        res[i - 1] = s[st - 1];
        while (st <= numRows) {
            next1 = cur + 2 * numRows - 2 * st;
            next2 = next1 + 2 * (st - 1);
            if ((next1 != next2) && (cur != next1)) {
                if (next1 <= n) {
                    ++i;
                    res[i - 1] = s[next1 - 1];
                }
                else {
                    ++st;
                    if (st <= numRows) {
                        ++i;
                        res[i - 1] = s[st - 1];
                    }
                    cur = st;
                    continue;
                }
            }
            if (next2 <= n) {
                ++i;
                res[i - 1] = s[next2 - 1];
            }
            else {
                ++st;
                if (st <= numRows) {
                        ++i;
                        res[i - 1] = s[st - 1];
                }
                cur = st;
                continue;                
            }
            cur = next2;
        }
        return res;
    }
};