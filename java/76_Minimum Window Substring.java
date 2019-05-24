/**
 * 难题，模板题，记下所有substring sliding window题的模板:
 * https://leetcode.com/problems/minimum-window-substring/discuss/26808/here-is-a-10-line-template-that-can-solve-most-substring-problems
 */

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> debtByChar= new HashMap<>();
        for (char c : t.toCharArray()) {
            debtByChar.put(c, debtByChar.getOrDefault(c, 0) + 1);
        }
        int begin = 0;
        int end = 0;
        int counter = t.length();
        int minLength = Integer.MAX_VALUE;
        int resultBegin = 0;
        while (end < s.length()) {
            int endDebt = debtByChar.getOrDefault(s.charAt(end), 0);
            debtByChar.put(s.charAt(end), endDebt - 1);
            ++end;
            if (endDebt > 0) { --counter; }            
            while (counter == 0 && begin < s.length()) {
                if (minLength > end - begin) {
                    minLength = end - begin;
                    resultBegin = begin;
                }
                int beginDebt = debtByChar.get(s.charAt(begin));
                if (beginDebt == 0) {
                    ++counter;
                }
                debtByChar.put(s.charAt(begin), beginDebt + 1);
                ++begin;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(resultBegin, resultBegin + minLength);
    }
}