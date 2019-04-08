class Solution {
public:
    string mostCommonWord(string paragraph, vector<string>& banned) {
        for_each(paragraph.begin(), paragraph.end(), [](char& c)->void{
            if (isalpha(c)) { c = tolower(c); }
            else { c = ' '; };
        });
        unordered_set<string> ban_words;
        for (auto ban_word : banned) {
            ban_words.insert(ban_word);
        }
        unordered_map<string, int> mp;        
        istringstream is(paragraph);
        int max_occur = 0;
        string ans;
        string word;
        while (is >> word) {            
            // ! ban_words.contains(word)
            if (ban_words.find(word) == ban_words.end()) {
                int occur = ++mp[word];                
                if (max_occur < occur) {
                    max_occur = occur;
                    ans = word;
                }
            }
        }
        return ans;
    }
};