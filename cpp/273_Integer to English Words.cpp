/*
每三位处理一下
注意零的判断，以及30要表示成Thirty, 而不是Thirty Zero
然后0~19要特殊处理
*/
class Solution {
public:
    string getHundredRepresentation(int num) {
        string result;
        if (num >= 100) {
            result += numToString[num / 100] + " Hundred ";
            num %= 100;
        }
        if (num > 20) {
            result += tenNumToString[num / 10] + " ";
            if (num % 10) {
                result += numToString[num % 10] + " ";
            }
        } else if (num > 0) {
            result += numToString[num] + " ";
        }
        return result;
    }
    string numberToWords(int num) {
        string result;
        if (num >= 1000000000) {
            result += getHundredRepresentation(num / 1000000000);
            result += "Billion ";
            num %= 1000000000;
        }
        if (num >= 1000000) {
            result += getHundredRepresentation(num / 1000000);
            result += "Million ";
            num %= 1000000;
        }
        if (num >= 1000) {
            result += getHundredRepresentation(num / 1000);
            result += "Thousand ";
            num %= 1000;
        }
        if (num >= 0) {
            result += getHundredRepresentation(num);
            if (result.empty()) {
                result = "Zero ";
            }
        }
        result.erase(--result.end());                
        return result;
    }
private:
    string numToString[21]{"Zero", "One", "Two", "Three",
                             "Four", "Five", "Six", "Seven",
                             "Eight", "Nine", "Ten", "Eleven",
                             "Twelve", "Thirteen", "Fourteen", 
                             "Fifteen", "Sixteen", "Seventeen",
                             "Eighteen", "Nineteen", "Twenty"
                            };
    string tenNumToString[10]{"", "", "Twenty",
                             "Thirty", "Forty", "Fifty",
                              "Sixty", "Seventy", "Eighty",
                              "Ninety"
                             };
};