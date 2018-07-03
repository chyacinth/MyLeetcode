/**
 * 简单dp
 * 注意可以节约一个维度，但是这样就要求dp倒序
 */
class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    if (n == 0) return 0;
    if (n == 1) return triangle.get(0).get(0);
    int[] dp = new int[n];
    dp[0] = triangle.get(0).get(0);
    int result = 0;
    
    for (int i = 1; i < n; i++) {
      dp[i] = dp[i - 1] + triangle.get(i).get(i);
      for (int j = i - 1; j > 0; j--) {
        dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
      }
      dp[0] += triangle.get(i).get(0);
      if (i == n - 1) {
        result = dp[0];
        for (int j = 1; j < n; j++) {
          if (dp[j] < result) {
            result = dp[j];
          }
        }
      }
    }
    return result;
  }
}