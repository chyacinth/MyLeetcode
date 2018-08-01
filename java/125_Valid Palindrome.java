class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {            
            while (start < s.length() && 
                   !Character.isLetter(s.charAt(start)) &&
                   !Character.isDigit(s.charAt(start))) {
                ++start; 
            }
            while (end >= 0 && 
                  !Character.isLetter(s.charAt(end)) &&
                  !Character.isDigit(s.charAt(end))) {
                --end;
            }
            if (start < s.length() && end >= 0) {
                if (s.charAt(start) != s.charAt(end) &&
                   Character.toUpperCase(s.charAt(start)) !=
                    Character.toUpperCase(s.charAt(end))) {
                    return false;
                }
            }
            ++start;
            --end;
        }
        return true;
    }
}