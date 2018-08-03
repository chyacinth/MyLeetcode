class Solution {
public:
    string longestPalindrome(string s) {
        int left, right, length, offset = 0, max = 0, st, ed;
        string result;
        for (int i = 0; i < s.length(); i++){
            // odd
            length = 1;
            offset = 1;
            if ((i - 1 >= 0) && (i + 1 < s.length())) {
                left = s[i - 1];
                right = s[i + 1];                
                while (left == right) {
                    offset += 1;
                    if ((i - offset >= 0) && (i + offset < s.length())) {                        
                        left = s[i - offset];
                        right = s[i + offset];                        
                    } else {
                        break;                    
                    }
                }
                length = 1 + 2 * (offset - 1);
            }
            if (max < length) {
                max = length;
                st = i - offset + 1;
                ed = i + offset - 1;
            }
            
            // even
            length = 0;
            offset = 1;
            if (i - 1 >= 0){
                left = s[i - 1];
                right = s[i];
                offset = 1;
                while (left == right){
                    offset += 1;
                    if ((i - offset >= 0) && (i + offset - 1 < s.length())) {
                        left = s[i - offset];
                        right = s[i + offset - 1];
                    }
                    else {
                        break;
                    }
                }
                length = 2 * (offset - 1);
            }
            if (max < length) {
                max = length;
                st = i - offset + 1;
                ed = i + offset - 2;
            }
        }
        result = s.substr(st, max);        
        return result;
    }
};