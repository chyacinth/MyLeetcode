/*
未完全优化的版本
搜索
合法的parenthesese有一个性质，合法的parenthesese等价于每一个0~i的子串的左括号个数都大于等于右括号的个数，且总左括号个数等于总右括号个数。
因此在搜索的过程中 可以通过保证左括号个数一定大于右括号个数来剪枝。
注意结果要用unordered_set存起来，因为会有重复
 */
class Solution {
public:    
    void dfs(
        string s,
        int index,
        int left_count,
        int right_count,
        string result,
        int removed_count
    ) {
        if (index == s.length()) {
            if (left_count == right_count and 
                removed_count <= min_removed_count) {
                if (removed_count < min_removed_count) {
                    results.clear();
                    min_removed_count = removed_count;
                }
                results.insert(result);
            }
        } else {
            char ch = s[index];
            // no bracket case
            if (ch != '(' and ch != ')') {
                dfs(s, index + 1, left_count, right_count,
                   result + ch, removed_count);
            } else {                
                // discard case
                dfs(s, index + 1, left_count, right_count,
                   result, removed_count + 1);
                // no discard case
                if (ch == '(') {
                    dfs(s, index + 1, left_count + 1, right_count,
                   result + '(', removed_count);
                } else if (ch == ')' and left_count > right_count) {
                    dfs(s, index + 1, left_count, right_count + 1,
                   result + ')', removed_count);
                }
            }
        }
    }
    vector<string> removeInvalidParentheses(string s) {
        dfs(s, 0, 0, 0, "", 0);
        return vector<string>(results.begin(), results.end());
    }  
private:
    unordered_set<string> results;
    int min_removed_count = numeric_limits<int>::max();
};