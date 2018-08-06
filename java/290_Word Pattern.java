/**
 * 注意
 */
class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (str == null) { return false; }
        Map<Character, String> patternStrMap = new HashMap<>();
        Map<String, Character> strPatternMap = new HashMap<>();
        int cnt = 0;
        for (String s : str.split(" ")) {
            if (cnt >= pattern.length()) {return false;}
            char ch = pattern.charAt(cnt++);
            String storedString = patternStrMap.get(ch);
            if (storedString == null) {
                patternStrMap.put(ch, s);
            } else {
                if (!storedString.equals(s)) {
                    return false;
                }
            }
            Character storedCharacter = strPatternMap.get(s);
            if (storedCharacter == null) {
                strPatternMap.put(s, ch);
            } else {
                if (!storedCharacter.equals(ch)) {
                    return false;
                }
            }
        }
        if (cnt < pattern.length()) return false;
        return true;
    }
}