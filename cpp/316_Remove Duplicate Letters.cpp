/**
 * 非常难。。因为不知道怎么证明贪心算法。
 **/
class Solution {
public:
    string removeDuplicateLetters(string s) {
        string ans = "0";
        array<int, 26> occur;
        array<char, 26> record{};
        for (char c : s) {
            ++occur[c - 'a'];
        }
        for (char c : s) {
            --occur[c - 'a'];
            if (!record[c - 'a']) {
                while (ans.back() > c && occur[ans.back() - 'a'] > 0) {
                    record[ans.back() - 'a'] = false;
                    ans.pop_back();                    
                }
                ans.push_back(c);
                record[c - 'a'] = true;
            }
        }
        
        return ans.substr(1);
    }
};