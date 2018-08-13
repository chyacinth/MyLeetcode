/**
 * 并查集，多增加n各节点，表示与0~n-1的对立节点即可
 */
class Solution {
    static class UnionFind {
        int[] parent;
        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = -i;
            }
        }
        int Find(int x) {
            if (parent[x] < 0) {return x;}            
            int p = Find(parent[x]);
            parent[x] = p;
            return p;            
        }
        void Union(int x, int y) {
            int px = Find(x);
            int py = Find(y);
            if (px != py) {
                parent[px] = py;
            }            
        }
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        if (graph.length == 0) {
            return true;
        }
        UnionFind unionFind = new UnionFind(2 * n + 1);        
        for (int i = 0; i < n; ++i) {
            int ni = i + 1;
            for (int j = 0; j < graph[i].length; ++j) {
                int nj = graph[i][j] + 1;
                int pi = unionFind.Find(ni);
                int pj = unionFind.Find(nj);
                if (pi == pj) { return false; }
                unionFind.Union(ni + n, nj);
                unionFind.Union(ni, nj + n);                
            }
        }
        return true;
    }
}