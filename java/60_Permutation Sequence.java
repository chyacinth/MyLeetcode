class Solution {    
    public boolean[] used;
    public int fact(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    public String getPermutationRecursion(int n, int k) {
        int factor = fact(n - 1), tar = (k - 1) / factor;
        int cnt = 0;
        //if (k == 0)        
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                if (cnt == tar) {
                    used[i] = true;
                    return String.valueOf(i + 1) + getPermutationRecursion(n - 1, k - tar * factor);
                }
                cnt += 1;
            }
        }
        return "";
    }
    public String getPermutation(int n, int k) {
        used = new boolean[n];
        return getPermutationRecursion(n,k);
    }
}