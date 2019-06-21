/**
 * 这类题基本上只有并查集可以。
 * 用Map的话会无法处理 name, email1, email2; name, email3, email4; name, email2, email3 的情况
 */
class Solution {
    class UnionFind {
        int[] p;
        UnionFind(int n) {
            p = new int[n];
            Arrays.fill(p, -1);
        }        
        int find(int x) {
            if (p[x] != -1) {
                int rep = find(p[x]);
                p[x] = rep;
                return rep;
            }
            return x;
        }
        int union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx > fy) {
                p[fx] = fy;
                return fy;
            } else if (fx < fy) {
                p[fy] = fx;
                return fx;
            }
            return fx;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind unionFind = new UnionFind(n);
        Map<String, Integer> emailToId = new TreeMap<>();
        String[] names = new String[n];
        for (int i = 0; i < n; ++i) {
            List<String> acc = accounts.get(i);
            names[i] = acc.get(0);
            for (int j = 1; j < acc.size(); ++j) {
                String email = acc.get(j);
                if (emailToId.containsKey(email)) {
                    int id = emailToId.get(email);
                    unionFind.union(id, i);
                }
                emailToId.put(acc.get(j), i);
            }
        }
        List<List<String>> resultsWithEmpty = new ArrayList<>();
        for (String email : emailToId.keySet()) {
            int id = unionFind.find(emailToId.get(email));
            while (id >= resultsWithEmpty.size()) {
                resultsWithEmpty.add(new ArrayList<>());
            }
            if (resultsWithEmpty.get(id).size() == 0) {
                resultsWithEmpty.get(id).add(names[id]);
            }
            resultsWithEmpty.get(id).add(email);
        }
        List<List<String>> results = new ArrayList<>();
        for (List<String> res : resultsWithEmpty) {
            if (res.size() > 0) {
                results.add(res);
            }
        }
        return results;
    }
}