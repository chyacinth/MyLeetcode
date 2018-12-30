/*
 Easy one
 */
class Solution {
public:
    string licenseKeyFormatting(string S, int K) {
        bool add_dash = false;
        int cnt = 0;
        string result;
        for (int i = S.length() - 1; i >= 0; --i) {
            char ch = S[i];
            if (isalnum(ch)) {
                if (add_dash) {
                    result.insert(0, "-");
                    add_dash = false;
                }
                result.insert(0, string(1, toupper(ch)));
                ++cnt;
                if (cnt == K) {
                    cnt = 0;
                    add_dash = true;
                }
            }
        }
        return result;
    }
};