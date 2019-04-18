/**
 * Easy
 **/ 
class Solution {
public:
  string validIPAddress(string IP) {    
    string result;
    if (IP.find('.') != string::npos) {
      result = "IPv4";
      IP += '.';
    } else if (IP.find(':') != string::npos) {
      result = "IPv6";
      IP += ':';
    } else {
        return "Neither";
    }
    istringstream is(IP);
    string number;
    int cnt = 0;
    if (result == "IPv4") {
      while (getline(is, number, '.')) {
        ++cnt;        
        if (!(number.size() == 1 || (number.size() > 1 && number.size() <= 3 && number[0] != '0') && all_of(number.begin(), number.end(), ::isdigit) && stoi(number) >= 0 && stoi(number) <= 255)) {
          return "Neither";
        }
      }
      if (cnt != 4) {        
        return "Neither";
      }
    } else {
      while (getline(is, number, ':')) {
        ++cnt;
        //cout << number.size() << " ";
        if (!(number.size() > 0 && number.size() <= 4 && all_of(number.begin(), number.end(), [](const char c) {
            return ::isdigit(c) || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
          }))) {
          return "Neither";
        }
      }
      if (cnt != 8) {
        return "Neither";
      }
    }
    return result;
  }
};