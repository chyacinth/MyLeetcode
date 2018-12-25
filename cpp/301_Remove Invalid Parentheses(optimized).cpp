/*
 可以事先计算出需要删掉的最少的括号数，然后dfs的时候记录还需要删掉多少左括号和右括号。这样可以提前剪枝。
 最少括号数就是看0~i子串中要删掉多少括号才能使得左右括号相同。具体方法看代码
 */
class Solution {
public:    
    void dfs(
        string s,
        int index,
        int left_count,
        int right_count,
        int left_rem,
        int right_rem,
        string result) {
        if (index == s.length()) {
            if (left_rem == 0 and
                right_rem == 0) { results.insert(result); }
        } else {
            char ch = s[index];
            // none bracket case
            if (ch != '(' and ch != ')') {
                dfs(s, index + 1, left_count, right_count,
                    left_rem, right_rem, result + ch);
            } else {
                // discard case
                if (ch == '(' and left_rem > 0 or ch == ')' and right_rem >0 ) {
                    dfs(s, index + 1, left_count, right_count,
                        left_rem - (ch == '('? 1 : 0),
                        right_rem - (ch == ')'? 1 : 0),
                        result);
                }                
                // no discard case
                if (ch == '(') {
                    dfs(s, index + 1, left_count + 1, right_count,
                        left_rem, right_rem, result + '(');
                } else if (ch == ')' and left_count > right_count) {
                    dfs(s, index + 1, left_count, right_count + 1,
                        left_rem, right_rem, result + ')');
                }
            }
        }
    }
    vector<string> removeInvalidParentheses(string s) {
        int left_rem = 0, right_rem = 0;
        for (auto ch : s) {
            if (ch == '(') { ++left_rem; }
            if (ch == ')') {
                if (left_rem > 0) { --left_rem; }
                else {
                    ++right_rem;
                }
            }
        }
        dfs(s, 0, 0, 0, left_rem, right_rem, "");
        return vector<string>(results.begin(), results.end());
    }  
private:
    unordered_set<string> results;
};