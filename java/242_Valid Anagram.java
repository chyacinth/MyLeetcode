/**
 * 记录词频
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] rcd = new int[26];
        if (s.length() != t.length()) { return false; }
        for (char c : s.toCharArray()) {
            rcd[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            rcd[c - 'a'] -= 1;
        }
        for (int a : rcd) {
            if (a != 0) return false;
        }
        return true;
    }
}