/**
 * Difficult, see https://leetcode.com/problems/palindrome-pairs/discuss/79215/Easy-to-understand-AC-C%2B%2B-solution-O(n*k2)-using-map
 **/ 
class Solution {
public:
    bool isPalindrome(const string& s, int l, int r) {        
        while (l <= r && s[l] == s[r]) {
            ++l;
            --r;
        }
        return (l > r);        
    }
    
    vector<vector<int>> palindromePairs(vector<string>& words) {
        unordered_map<string, vector<int>> mp;
        for (int i = 0; i < words.size(); ++i) {
            reverse(words[i].begin(), words[i].end());
            mp[words[i]].push_back(i);
        }
        vector<vector<int>> res;
        for (int i = 0; i < words.size(); ++i) {            
            string &w = words[i];
            if (w == "") {
                for (int j = 0; j < words.size(); ++j) {
                    if (words[j] != "" && isPalindrome(words[j], 0, words[j].size() - 1)) {
                        res.push_back({i, j});
                        res.push_back({j, i});
                    }
                }
                continue;
            }
            reverse(w.begin(), w.end());
            for (int j = 0; j < w.size(); ++j) {
                string subw = w.substr(0, j + 1);
                if (mp.find(subw) != mp.end() && isPalindrome(w, j + 1, w.size() - 1)) {
                    for (int k : mp[subw]) {
                        if (i != k) {
                            res.push_back({i, k});
                        }
                    }                    
                }
                if (j == 0) { continue; }
                subw = w.substr(j, w.size() - j);
                if (mp.find(subw) != mp.end() && isPalindrome(w, 0, j - 1)) {
                    for (int k : mp[subw]) {
                        if (k != i) {
                            cout << w << " " << subw << endl;
                            res.push_back({k, i});
                        }
                    }                    
                }
                
            }
        }
        return res;
    }
};