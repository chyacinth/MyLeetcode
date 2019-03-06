/**
 * Easy
 **/ 
class Solution {
public:
    int firstUniqChar(string s) {
        array<char, 26> occurs{};
        for (int i = 0; i < s.size(); ++i) {
            if (occurs[s[i] - 'a'] < 2) ++occurs[s[i] - 'a'];
        }        
        for (int i = 0; i < s.size(); ++i) {
            if (occurs[s[i] - 'a'] == 1) {return i;}
        }
        return -1;
    }
};