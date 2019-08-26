/**
 * 转化为求最短汉密尔顿回路，可以用动归做，见http://slp3ourteam.blog.sohu.com/64858057.html
 */
class Solution {
  public String shortestSuperstring(String[] A) {
    int n = A.length;
    int[][] dp = new int[n][1 << n];
    int[][] graph = new int[n][n];
    
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        if (i != j) {
          graph[i][j] = calc(A[i], A[j]);
        }
      }
    }
    
    for (int cluster = 1; cluster < (1 << n); ++cluster) {
      for (int t = 0; t < n; ++t) {
       dp[t][cluster] = Integer.MAX_VALUE; 
      }
      for (int i = 0; i < n; ++i) {
        if (((1 << i) & cluster) == 0) {
          for (int j = 0; j < n; ++j) {
            if (((1 << j) & cluster) > 0) {
              int prev = cluster - (1 << j);
              dp[i][cluster] = Math.min(dp[i][cluster], graph[i][j] + dp[j][prev]);
            }
          }
        }
      }
    }
    int min = Integer.MAX_VALUE;
    int start = 0;
    for (int i = 0; i < n; ++i) {
      int cluster = (1 << n) - 1 - (1 << i);
      if (min > dp[i][cluster] + A[i].length()) {
        min = dp[i][cluster] + A[i].length();
        start = i;
      }
    }
    StringBuilder result = new StringBuilder(A[start]);
    int cluster = (1 << n) - 1 - (1 << start);
    for (int t = 0; t < n-1; ++t) {
      for (int next = 0; next < n; ++next) {
        int cluster2 = cluster - (1 << next);
        if (graph[start][next] + dp[next][cluster2] == dp[start][cluster]) {
          int addLen = calc(A[start], A[next]);
          start = next;
          cluster = cluster2;
          result.append(A[start].substring(A[start].length() - addLen));
          break;
        }
      }
    }
    return result.toString();
  }
  
  private int calc(String a, String b) {
    for (int i = 1; i < a.length(); i++) {
      if (b.startsWith(a.substring(i))) {
        return b.length() - a.length() + i;
      }
    }
    return b.length();
  }
}