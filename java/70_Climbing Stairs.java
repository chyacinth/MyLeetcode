class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return (n==0?1:n);     
        int s1 = 1, s2 = 2, s3 = 0;
        for (int i = 3; i <= n; i++) {
            s3 = s1 + s2;
            s1 = s2;
            s2 = s3;
        }
        return s3;
    }
}