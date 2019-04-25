/**
 * simple
 **/ 
class Solution {
public:
  string addStrings(string num1, string num2) {
    reverse(num1.begin(), num1.end());
    reverse(num2.begin(), num2.end());
    string num3;
    int add = 0;
    for (int i = 0; i < max(num1.size(), num2.size()); ++i) {
      int l = 0;
      int r = 0;
      if (i < num1.size()) {
        l = num1[i] - '0';
      } else {
        l = 0;
      }
      if (i < num2.size()) {
        r = num2[i] - '0';
      } else {
        r = 0;
      }
      int sum = l + r + add;
      add = sum / 10;
      sum = sum % 10;
      num3.push_back(sum + '0');
    }
    if (add) {
      num3.push_back(add + '0');
    }
    reverse(num3.begin(), num3.end());
    return num3;
  }
};