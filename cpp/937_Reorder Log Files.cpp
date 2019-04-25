class Solution {
public:
  bool is_letter(const string& str) {
    istringstream is(str);
    string word;
    is >> word;
    is >> word;
    if (isalpha(word[0])) return true;
    return false;
  }
  vector<string> reorderLogFiles(vector<string>& logs) {    
    int r = logs.size() - 1;
    int l = r;
    while (r >= 0 && l >= 0) {
      while (r >= 0 && !is_letter(logs[r])) {
        --r;
      }
      l = r;
      while (l >= 0 && is_letter(logs[l])) {
        --l;
      }
      if (l >= 0) swap(logs[l], logs[r]);
    }    
    //cout << r << endl;
    auto mid = logs.begin() + r + 1;
    auto cmp = [](const string& str1, const string& str2) {
      istringstream is1(str1);
      istringstream is2(str2);
      string word1;
      string word2;
      is1 >> word1;
      is2 >> word2;
      string s1;
      string s2;
      getline(is1, s1);
      getline(is2, s2);
      //cout << s1 << " " << s2 << endl;
      return (s1 < s2 || (s1 == s2 && word1 < word2));
    };
    //cout << *mid << endl;
    sort(logs.begin(), mid, cmp);
    return logs;
  }
};