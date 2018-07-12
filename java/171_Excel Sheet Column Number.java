/**
 * 26进制
 */
class Solution {
    public int titleToNumber(String s) {
        int base = 1;
        int result = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            result += (s.charAt(i) - 'A' + 1) * base;
            base *= 26;
        }
        return result;
    }
}