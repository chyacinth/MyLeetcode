/**
 * 难题。转换成图论题，发现是汉密尔顿回路，但是每个点的度很小，暴力搜索之。
 **/ 
class Solution {
public:
    bool dfs(const int target, const int k, const string& current, unordered_set<string>& visited, string& result) {
        if (visited.size() == target) {
            return true;
        }
        string prefix = current.substr(1, current.size());
        for (int i = 0; i < k; i++) {
            string next = prefix + to_string(i);
            // !visited.contains(next)
            if (visited.find(next) == visited.end()) {
                visited.insert(next);
                result += to_string(i);
                if (!dfs(target, k, next, visited, result)) {
                    result.pop_back();
                    visited.erase(next);
                } else {
                    return true;
                }
                
            }
        }
        return false;
    }
    string crackSafe(int n, int k) {
        unordered_set<string> visited;
        string result(string(n - 1, '0'));
        dfs(pow(k, n), k, string(n, '0'), visited, result);
        return result;
    }
private:
    
};