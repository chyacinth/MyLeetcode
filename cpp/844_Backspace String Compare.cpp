/**
 * We just need to modify the original string to let it store the trimmed string
 **/ 
class Solution {
public:
    int removeStr(string &s) {
        int p = 0;
        for (int i = 0; i < s.size(); ++i) {
            if (isalpha(s[i])) {
                s[p++] = s[i];
            } else if (s[i] == '#') {
                if (p - 1 >= 0)
                    s[--p] = '_';
            }
        }
        return p;
    }
    
    bool backspaceCompare(string S, string T) {
        int l1 = removeStr(S);
        int l2 = removeStr(T);
        int i1 = 0, i2 = 0;
        if (l1 != l2) { return false; }
        for (int i = 0; i < l1; ++i) {
            if (S[i] != T[i]) return false;
        }
        return true;
    }
};