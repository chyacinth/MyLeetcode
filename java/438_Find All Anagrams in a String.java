/**
 * Use a map to record the occurrence frecurency of each character.
 * Use a loop to iterate the stirng,
 * in the ith loop, calculate the freq. of string s(i-p.length, i)
 * the freq. can be obtained within O(1) by freq. of previous iter
 */
class Solution {
public:
  vector<int> findAnagrams(string s, string p) {
    vector<int> occur(26);
    vector<int> target(26);
    vector<int> result;
    if (s.length() < p.length() || p.length() == 0 || s.length() == 0) {
      return result;
    }
    for (int i = 0; i < p.length(); ++i) {
      ++occur[s[i] - 'a'];
      ++target[p[i] - 'a'];
    }
    int matched = 0;
    int char_num = 0;    
    for (int i = 0; i < 26; ++i) {
      if (target[i] != 0) {
        ++char_num;
        if (target[i] == occur[i]) {
          ++matched;
        }
      }
    }    
    if (matched == char_num) result.push_back(0);
    for (int i = p.length(); i < s.length(); ++i) {
      char removed_ch = s[i - p.length()];
      char added_ch = s[i];
      if ((occur[removed_ch - 'a'] == target[removed_ch - 'a']) && 
          (target[removed_ch - 'a'] != 0)) {
        --matched;
      }
      --occur[removed_ch - 'a'];
      if ((occur[removed_ch - 'a'] == target[removed_ch - 'a']) && 
          (target[removed_ch - 'a'] != 0)) {
        ++matched;
      }
      if ((occur[added_ch - 'a'] == target[added_ch - 'a']) && 
          (target[added_ch - 'a'] != 0)) {
        --matched;
      }
      ++occur[added_ch - 'a'];
      if ((occur[added_ch - 'a'] == target[added_ch - 'a']) && 
           (target[added_ch - 'a'] != 0)) {
        ++matched;
      }
      if (matched == char_num) result.push_back(i - p.length() + 1);
    }
    return result;
  }
};