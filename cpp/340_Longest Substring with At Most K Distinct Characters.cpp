/**
 * DP，计算以位置i结尾的字符串的最大长度max_len[i]。需要记录每个字母的最后出现位置。如果distinct num > k，
 * 需要找到第一个从位置 i - max_len[i-1]开始的最后出现位置==当前位置的字符，删掉。然后得到新的最长长度就完事了。
 **/ 
class Solution {
public:
    int lengthOfLongestSubstringKDistinct(string s, int k) {
        unordered_map<char, int> last_occur;
        int distinct_num = 0;
        int max_len = 0;
        int result = 0;
        for (int i = 0; i < s.size(); ++i) {            
            char c = s[i];
            //cout << distinct_num << " ";
            // !last_occur.contains(c)
            if (last_occur.find(c) == last_occur.end()) {
                ++distinct_num;
            }
            last_occur[c] = i;
            if (distinct_num <= k) {
                ++max_len;
                result = max(result, max_len);
            } else {
                int j = i - max_len;
                while (last_occur[s[j]] != j) {
                    ++j;
                }
                //cout << j << " " << i;
                last_occur.erase(s[j]);
                --distinct_num;
                max_len = i - j;
            }
            //cout << endl;
        }
        return result;
    }
};