/**
 * 简单
 **/ 
class Solution {
public:
  string fractionToDecimal(int numerator, int denominator) {    
    long lnumerator = static_cast<long>(numerator);
    long ldenominator = static_cast<long>(denominator);
    if (lnumerator == 0) return "0";
    long sign = abs(lnumerator) / lnumerator * (abs(ldenominator) / ldenominator);
    lnumerator = abs(lnumerator);
    ldenominator = abs(ldenominator);    
    string integer;
    integer = (sign == -1? "-"s : ""s) + to_string(lnumerator / ldenominator);
    long rem = lnumerator % ldenominator;    
    if (rem == 0) return integer;
    integer += ".";
    unordered_map<long, long> record;
    long bit_num = 0;
    record[rem] = bit_num;
    rem *= 10;    
    string decimal;    
    while (rem != 0) {      
      long quo_bit = rem / ldenominator;
      decimal += to_string(quo_bit);
      rem = rem - quo_bit * ldenominator;
      if (record.find(rem) == record.end()) {        
        ++bit_num;
        record[rem] = bit_num;
      } else {        
        decimal = decimal.substr(0, record[rem]) + "("s + decimal.substr(record[rem], decimal.size()) + ")"s;
        break;
      }
      rem *= 10;
    }
    return integer + decimal;
  }
};