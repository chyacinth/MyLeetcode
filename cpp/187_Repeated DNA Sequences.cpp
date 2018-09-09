/**
 * Use HashMap to record the occurrence of each 10-digit substirng.
 */ 
class Solution {
public:
  vector<string> findRepeatedDnaSequences(string s) {
    if (s.length() < 10) {
      return result_;
    }    
    for (int i = 0; i <= s.length() - 10; ++i) {
      string sub_string = s.substr(i, 10);
      if (++occur_map_[sub_string] == 2) {
        result_.push_back(sub_string);
      }
    }
    return result_;
  }
private:
  unordered_map<string, int> occur_map_;
  vector<string> result_;
};