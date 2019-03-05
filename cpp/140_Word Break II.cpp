/**
 * 略难题。Dfs+剪枝。注意观察什么时候状态会重复？（当substring相同的时候），所以我们需要对
 * 每个substring保存结果。这样的话下次再遇到就可以直接返回结果。
 * 见 https://leetcode.com/problems/word-break-ii/solution/
 **/ 
class Solution {
public:
    vector<string> helper(const string &s) {        
        if (mp.find(s) != mp.end()) {
            return mp[s];
        }
        for (int i = 1; i <= min(static_cast<int>(s.size()), max_len); ++i) {            
            if (string subs = s.substr(0, i); dict.find(subs) != dict.end()) {
                for (auto&& ds : helper(s.substr(i, s.size()))) {
                    if (!ds.empty()) {
                        mp[s].push_back(subs + " " + ds);
                    } else {
                        mp[s].push_back(subs);
                    }
                }
            }
        }
        return mp[s];
    }
    
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        for (auto word : wordDict) {
            dict.insert(word);
            max_len = max(max_len, static_cast<int>(word.size()));
        }                
        
        return helper(s);
    }
private:
    unordered_map<string, vector<string>> mp{{"",{""}}};
    unordered_set<string> dict;
    int max_len = 0;
};