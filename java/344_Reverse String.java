class Solution {
    public String reverseString(String s) {
        char[] ch = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ch[i] = s.charAt(ch.length - i - 1);
        }
        return String.valueOf(ch);
    }
}