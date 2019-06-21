/**
 * DP，dp[n] = dp[n-1] + 以s[n]结尾的所有子串的unique个数
 * 以s[n]结尾的所有子串的unique个数 = 以s[n-1]结尾的所有子串的unique个数+s[n]倒数第一次和s[n]倒数第二次之间的距离 - s[n]倒数第二次和s[n]倒数第三次之间的距离
 */
class Solution {
    public int uniqueLetterString(String S) {
        Map<Character, List<Integer>> occursByChar = new HashMap<>();
        int[] dp = new int[S.length()];
        int result = 0;
        int toAdd = 0;
        for (int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            List<Integer> occurs = occursByChar.getOrDefault(c, new ArrayList<>());                        
            if (occurs.size() == 0) {
                toAdd += i + 1;
            } else if (occurs.size() == 1) {
                toAdd += i - occurs.get(0);
                toAdd -= occurs.get(0) + 1;
            } else {
                toAdd += i - occurs.get(occurs.size() - 1);
                toAdd -= occurs.get(occurs.size() - 1) - occurs.get(occurs.size() - 2);
            }
            occurs.add(i);
            occursByChar.put(c, occurs);
            result += toAdd;            
        }
        return result;
    }
}