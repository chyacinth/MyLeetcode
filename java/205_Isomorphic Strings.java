/**
 * 用两个map(单射)完成一个双射
 * 想更快的话可以用数组作为map
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mapts = new HashMap<>();
        HashMap<Character, Character> mapst = new HashMap<>();
        int len = s.length();
        if (len != t.length()) return false;        
        for (int i = 0; i < s.length(); ++i) {
            if (mapts.get(t.charAt(i)) == null) {
                mapts.put(t.charAt(i), s.charAt(i));
            } else {
                if (s.charAt(i) != mapts.get(t.charAt(i))) { return false; }
            }
            
            if (mapst.get(s.charAt(i)) == null) {
                mapst.put(s.charAt(i), t.charAt(i));
            } else {
                if (t.charAt(i) != mapst.get(s.charAt(i))) { return false; }
            }
        }
        return true;
    }    
}