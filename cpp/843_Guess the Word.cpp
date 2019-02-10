/**
 * Quite difficult. See https://leetcode.com/problems/guess-the-word/discuss/133862/Random-Guess-and-Minimax-Guess-with-Comparison
 * for answer
 **/ 
/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Master {
 *   public:
 *     int guess(string word);
 * };
 */
class Solution {
public:
    int match(const string& s1, const string& s2) {
        int result = 0;
        for (int i = 0; i < s1.size(); ++i) {
            if (s1[i] == s2[i]) ++result;
        }
        return result;
    }
    void findSecretWord(vector<string>& wordlist, Master& master) {
        for (int _i = 0; _i < 10; ++_i) {
            unordered_map<string, int> count;
            for (const auto &s1 : wordlist) {
                for (const auto &s2 : wordlist) {
                    if (match(s1,s2) == 0) {
                        ++count[s1];
                    }
                }
            }
            pair<string, int> min_zero = {wordlist[0], numeric_limits<int>::max()};
            for (const auto& word : wordlist) {
                if (count[word] < min_zero.second) {
                    min_zero = {word, count[word]};
                }
            }
            //cout << min_zero.first << endl;
            int matched_num = master.guess(min_zero.first);
            if (matched_num == 6) { return; }
            vector<string> new_wordlist;
            for (auto &s1 : wordlist) {
                if (match(min_zero.first, s1) == matched_num) {
                    new_wordlist.push_back(s1);
                }
            }            
            std::swap(wordlist, new_wordlist);
        }
    }
};