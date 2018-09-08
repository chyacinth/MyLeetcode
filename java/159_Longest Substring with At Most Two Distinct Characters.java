/**
 * Dynamic Programming
 * Use a loop to get the result of substring(0,i)
 * During the loop, maintain location of the two characters.
 * Record their first and last occurrence.
 */
class Solution {
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    if (s.isEmpty()) { return 0; }
    int l = 0;
    int r = 0;
    int first = -1; 
    int lastFirst = -1;
    int second = -1;    
    int lastSecond = -1;
    int result = 0;
    while (r < s.length()) {
      if (first == -1) {        
        first = r;
        lastFirst = first;
      } else if (second == -1 && s.charAt(r) != s.charAt(first)) {
        second = r;
        lastSecond = r;
      } else {
        if (s.charAt(r) != s.charAt(first) && s.charAt(r) != s.charAt(second)) {
          result = Math.max(result, r - first);
          first = Math.min(lastFirst, lastSecond) + 1;
          if (lastFirst + 1 == first) { lastFirst = lastSecond; }          
          second = r;           
          lastSecond = r;
        } else if (s.charAt(r) == s.charAt(first)){
          lastFirst = r;
        } else if (s.charAt(r) == s.charAt(second)){
          lastSecond = r;
        }
      }
      ++r;
    }
    result = Math.max(result, r - first);    
    return result;
  }
}