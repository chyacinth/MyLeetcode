/**
 * 简单。只要每次选出现次数最多的那个，如果不行就第二多的。如果没有能选的说明找不到了。
 **/ 
class Solution {
public:
    string reorganizeString(string S) {
      array<int, 26> char_count{};
      multimap<int, char> occurs;
      string result;
      for (char c : S) {
        ++char_count[c - 'a'];
      }
      for (int i = 0; i < 26; ++i) {
        if (char_count[i] > 0) {
          occurs.insert(make_pair(char_count[i], i + 'a'));
        }
        //if (char_count[i] > 0) cout << static_cast<char>(i + 'a') << " ";
      }
      
      for (int i = 0; i < S.size(); ++i) {        
        auto max_occur = prev(occurs.end());
        if (result.empty() || max_occur->second != result.back()) {
          result.push_back(max_occur->second);
          if (max_occur->first - 1 > 0) {
            occurs.insert(make_pair(max_occur->first - 1, max_occur->second));
          }
          occurs.erase(max_occur);
        } else {          
          if (occurs.size() < 2) {
            return "";
          }
          max_occur = prev(occurs.end(), 2);
          result.push_back(max_occur->second);
          if (max_occur->first - 1 > 0) {
            occurs.insert(make_pair(max_occur->first - 1, max_occur->second));
          }
          occurs.erase(max_occur);
        }
      }
      return result;
    }
};