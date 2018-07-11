class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < wordDict.size(); ++j) {
                String word = wordDict.get(j);
                int len = word.length();
                if (i - len >= 0 && dp[i - len] && 
                    s.substring(i - len,i).equals(word)) {
                        dp[i] = true;
                        break;
                }
            }            
        }
        return dp[s.length()];
    }
}