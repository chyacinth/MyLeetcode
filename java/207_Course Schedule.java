class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Deque<Integer> bfs = new ArrayDeque<>();
        Map<Integer, List<Integer>> g = new HashMap<>();
        int[] d = new int[numCourses];
        for (int[] pre : prerequisites) {
            List<Integer> toPut = g.getOrDefault(pre[1], new ArrayList<>());
            toPut.add(pre[0]);
            g.put(pre[1], toPut);
            ++d[pre[0]];
        }   
        for (int i = 0; i < numCourses; ++i) {
            if (d[i] == 0) {
                bfs.offer(i);
            }
        }
        int cnt = 0;        
        while (!bfs.isEmpty()) {
            int idx1 = bfs.poll();
            ++cnt;
            if (g.containsKey(idx1)) {
                for (int idx2 : g.get(idx1)) {
                    d[idx2]--;
                    if (d[idx2] == 0) {
                        bfs.offer(idx2);
                    }
                }
            }
        }
        return cnt == numCourses;
    }
}