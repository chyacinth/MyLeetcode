/**
 * Easy DIJKSTRA
 * 
 */
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] g = new int[N+1][N+1];
        Set<Integer> candidates = new HashSet<Integer>();
        candidates.add(K);
        int[] estimate = new int[N+1];
        Arrays.fill(estimate, -1);
        Arrays.stream(g).forEach(a -> Arrays.fill(a, -1));
        for (int[] t : times) {
            g[t[0]][t[1]] = t[2];            
        }
        
        estimate[K] = 0;
        
        while (!candidates.isEmpty()) {
            int minCand = -1;
            for (int cand : candidates) {                
                if (minCand == -1) {
                    minCand = cand;
                }
                if (estimate[cand] < estimate[minCand] && estimate[cand] != -1) {
                    minCand = cand;
                }
            }
            //System.out.println(minCand);
            candidates.remove(minCand);
            for (int i = 1; i <= N; ++i) {
                if (g[minCand][i] != -1 && (estimate[i] > estimate[minCand] + g[minCand][i] || estimate[i] == -1)) {
                    estimate[i] = estimate[minCand] + g[minCand][i];
                    if (!candidates.contains(i)) {
                        candidates.add(i);
                    }
                }
            }
            
        }
        int result = 0;
        for (int i = 1; i <= N; ++i) {
            int est = estimate[i];
            //System.out.println(est);
            if (est == -1) return -1;
            if (est > result) result = est;            
        }
        return result;
    }
}