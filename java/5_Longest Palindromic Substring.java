class Solution {
    public String longestPalindrome(String s) {
        int result = 0;
        int sl = 0;
        int sr = s.length() - 1;
        for (int i = 0; i < s.length(); ++i) {
            int temp = 1;
            int l = i - 1;
            int r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                temp += 2;
                l -= 1;
                r += 1;
            }
            if (result < temp) {
                result = temp;
                sl = l + 1;
                sr = r - 1;
            }
            
            temp = 0;
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                temp += 2;
                l -= 1;
                r += 1;
            }
            if (result < temp) {
                result = temp;
                sl = l + 1;
                sr = r - 1;
            }
        }
        return s.substring(sl, sr + 1);
    }
}