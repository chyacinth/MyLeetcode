/**
 * 模板解法
 * https://leetcode.com/problems/minimum-window-substring/discuss/26808/here-is-a-10-line-template-that-can-solve-most-substring-problems
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> occurByChar = new HashMap<>();
        int begin = 0;
        int end = 0;
        int counter = 0;
        int result = 0;
        
        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (occurByChar.getOrDefault(c1, 0) > 0) { ++counter; }            
            occurByChar.put(c1, occurByChar.getOrDefault(c1, 0) + 1);
            ++end;
            while (counter > 0) {
                char c2 = s.charAt(begin);
                if (occurByChar.get(c2) > 1) { --counter; }
                occurByChar.put(c2, occurByChar.get(c2) - 1);
                ++begin;
            }
            result = Math.max(result, end - begin);
        }
        return result;
    }
}