class Solution {
    int[] parent;
    public void init_parent(int n) {
        parent = new int[n];
        Arrays.fill(parent, -1);
    }
    public int find(int x) {
        if (parent[x] == -1) { return x; }
        else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    public void union(int x, int y) {
        int p = find(x), q = find(y);
        if (p != q)
            parent[p] = q;
    }
    public int findCircleNum(int[][] M) {        
        int num = M.length;      
        int result = 0;
        boolean[] rec = new boolean[num];
        init_parent(num);        
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        for (int i = 0; i < M.length; i++) {
            if (rec[find(i)] == false) {
                result += 1;
                rec[find(i)] = true;
            }
        }
        return result;
    }
}