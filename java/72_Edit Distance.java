/*
操作的顺序不影响结果
考虑str1和str2匹配1，有如下几种方式
1. 如果最终结果str1的最后一位就是str2的最后一位，或者位置对应但是字母变换，则都可以由str1和str2除去最后一位的结果得到。
2. 如果最终结果str1的最后一位不是str2的最后一位，则：
    1. 若str1短于str2，则将插入看作最后一步，此时可以由子问题得到
    2. 若str1长与str2，则将删除最后一位看作第一步，此时可以由子问题得到
    3. 若str1与str2相等，则上述两种情况取最小（因为不知道最后一位对应的情况是删除还是插入）
以上两种情况得到的值去最小即为当前情况的距离，故用动态规划
*/

class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int lastEqual = (word1.charAt(i - 1) == word2.charAt(j - 1))? 0:1;                
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + lastEqual, dp[i][j - 1] + 1);                
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);                
            }
        }
        return dp[len1][len2];
    }
}