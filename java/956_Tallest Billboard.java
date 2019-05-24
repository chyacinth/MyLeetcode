/**
 * dp[delta][i]， 代表前i个元素，然后两根杆相差delta时的最长的那根长度。因为只有这样才能让第i时刻的杆的长度和前面的状态建立起关系。
 * （第i根杆能起到的影响就是改变两根杆之间的距离）
 */
// delta
// dp[j][i] = max(dp[j][i-1], dp[j + rods[i]][i-1], dp[j-rods[i]][i-1]] + rods[i])

class Solution {
    public int tallestBillboard(int[] rods) {   
        if (rods.length == 0) {
            return 0;
        }
                
        int[][] dp = new int[7000][rods.length];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        dp[rods[0]][0] = rods[0];        
        dp[0][0] = 0;
        for (int i = 1; i < rods.length; ++i) {
            for (int j = 0; j < 5002; ++j) {                
                dp[j][i] = dp[j][i-1];
                
                dp[j][i] = Math.max(dp[j][i], dp[j + rods[i]][i-1]);                
                
                if (rods[i] - j >= 0 && dp[rods[i] - j][i-1] != -1) {
                    dp[j][i] = Math.max(dp[j][i], dp[rods[i]-j][i-1] + j);
                }
                
                if (j - rods[i] >= 0 && dp[j-rods[i]][i-1] != -1) {
                    dp[j][i] = Math.max(dp[j][i], dp[j-rods[i]][i-1] + rods[i]);                    
                }                
            }            
        }
        if (dp[0][rods.length - 1] == -1) {
            return 0;
        }
        return dp[0][rods.length - 1];        
    }
}