class Solution {
    private Set<Integer> visited = new HashSet<>();
    private int result = -1;
    
    public void findCheapestPriceHelper(int n, int[][] g, int src, int dst, int K, int fee) {
        if (src == dst) { 
            if (result == -1 || (result != -1 && result > fee)) {
                result = fee;
            }
            return;
        }
        if (K == 0) { return; }        
        for (int j = 0; j < n; ++j) {
            if (g[src][j] != -1 && !visited.contains(j) && K > 0 && 
                (result == -1 || (result != -1 && fee + g[src][j] < result))) {
                findCheapestPriceHelper(n, g, j, dst, K - 1, fee + g[src][j]);
            }
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (src == dst) { return 0; }
        int[][] g = new int[n][n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                g[i][j] = -1;
        for (int[] flight : flights) {
            g[flight[0]][flight[1]] = flight[2];
        }
        findCheapestPriceHelper(n, g, src, dst, K + 1, 0);
        return result;
    }
}