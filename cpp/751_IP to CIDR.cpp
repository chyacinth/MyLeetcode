/**
 * 难题。
 * https://leetcode.com/problems/ip-to-cidr/discuss/228131/Java-Solution-with-Explanation
 **/ 
class Solution {
public:
  unsigned int ip_to_int(const string& ip) {
    istringstream is(ip);
    string number;
    unsigned int len = 24;
    int result = 0;
    while (getline(is, number, '.')) {
      result += stoi(number) * (1 << len);
      len -= 8;
    }
    return result;
  }
  string int_to_cidr(unsigned int x, int len) {
    string result;
    result += to_string(x >>24) + ".";
    result += to_string((x << 8) >> 24) + ".";
    result += to_string((x << 16) >> 24) + ".";
    result += to_string((x << 24) >> 24);
    result += "/"s + to_string(len);
    return result;
  }
  void dfs(unsigned int x1, int len, unsigned int start, unsigned int end) {
    
    unsigned int add_bit = len <= 32? 1 << (32 - len) : 0;
    unsigned int x2 = x1 + add_bit;
    unsigned int x3 = len <= 32? (x2 ^ (x2 - 1)) + x1 : x1;    
    if (start <= x1 && x3 <= end) {    
      ans.push_back((int_to_cidr(x1, len - 1)));
    } else {
      if (!(x2 - 1 < start || x1 > end)) {
        dfs(x1, len + 1, start, end);
      }
      if (!(x3 < start || x2 > end)) {
        dfs(x2, len + 1, start, end);
      }
    }
  }
  vector<string> ipToCIDR(string ip, int n) {
    unsigned int start = ip_to_int(ip);
    unsigned int end = start + n - 1;
    cout << start << " " << end << endl;
    dfs(0, 1, start, end);
    return ans;
  }
private:
  vector<string> ans;
};