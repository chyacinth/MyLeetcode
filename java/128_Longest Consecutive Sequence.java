/*
思路：将所有连续的数字放在一个集合中，如果有新的数x进来，则将x和x-1所在的集合和x+1所在的集合合并
对于合并，可以用并查集
*/
class Solution {
    static class UnionFind {
        int[] parent;
        int n;
        UnionFind(int then) {
            n = then;
            parent = new int[n];
            Arrays.fill(parent, -1);
        }
        int find(int x) {
            if (parent[x] >= 0) {
                parent[x] = find(parent[x]);
                return parent[x];
            }
            else return x;
        }
        void union(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx != fy) {
                parent[fy] += parent[fx];
                parent[fx] = fy;
            }                        
        }
        int getLargest() {
            int result = 0;
            for (int i = 0; i < n; i++) {
                if (parent[i] < result) result = parent[i];
            }
            return -result;
        }
    }
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();        
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        if (n <= 0) return 0;
        int result = 0;
        int value;
        int cnt = 0;        
        for (int i = 0; i < n; i++) {
            if (!set.contains(nums[i])) {
                map.put(nums[i], cnt);
                set.add(nums[i]);
                cnt += 1;
            }
        }
        UnionFind uf = new UnionFind(cnt);
        for (int i = 0; i < n; i++) {
            Integer getSmall = map.get(nums[i] - 1);
            Integer getLarge = map.get(nums[i] + 1);
            Integer getCurrent = map.get(nums[i]);
            if (getSmall != null) {
                uf.union(getSmall, getCurrent);
            }
            if (getLarge != null) {
                uf.union(getLarge, getCurrent);
            }
        }
        return uf.getLargest();
    }
}