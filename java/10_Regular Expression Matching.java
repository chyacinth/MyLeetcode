class Solution {
  private String tokeize(String p, boolean[] ast) {
    StringBuilder sb = new StringBuilder();
    int n = 0;
    for (int i = 0; i < p.length(); ++i) {
      sb.append(p.charAt(i));
      if (i + 1 < p.length() && p.charAt(i + 1) == '*') {
        ast[n] = true;
        ++i;
      }
      ++n;
    }
    return sb.toString();
  }
  public boolean isMatch(String s, String p) {
    boolean[] ast = new boolean[p.length()];
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    p = tokeize(p, ast);
    dp[0][0] = true;
    for (int i = 0; i <= s.length(); ++i) {
      for (int j = 0; j <= p.length(); ++j) {
        if (i == 0 && j == 0) {continue;}
        char sc = ' ';
        if (i > 0) {
           sc = s.charAt(i - 1);
        }
        char pc = ' ';
        if (j > 0) {
          pc = p.charAt(j - 1);
        }
        if (j - 1 >= 0 && !ast[j-1]) {
          if (i - 1 >= 0 && j - 1 >= 0) {
            dp[i][j] |= dp[i-1][j-1] & (pc == '.' | (pc == sc)) ;
          }
        } else {
          if (i >= 1 && j >= 1) {
            dp[i][j] |= dp[i-1][j-1] & (pc == '.' | sc == pc);
          }
          if (i >= 1) {
            dp[i][j] |= dp[i-1][j] & (pc == '.' | sc == pc);
          }
          if (j >= 1) {
            dp[i][j] |= dp[i][j-1];
          }
        }
      }
    }
    
    return dp[s.length()][p.length()];
  }
}