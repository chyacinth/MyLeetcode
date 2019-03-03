/**
 * 难题。要发现这是一个connected component问题啊啊啊啊啊啊
 * 然后可以用最简单的dfs，也可以用🐂🍺的union find。
 * 见 https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/discuss/197668/Count-the-Number-of-Islands-O(N)
 */ 
class Solution {
public:
    int removeStones(vector<vector<int>>& stones) {
        for (auto stone : stones) {
            uni(stone[0], stone[1] + 10000);
        }
        return stones.size() - sz;
    }
private:
    unordered_map<int, int> p;
    int sz = 0;
    
    int find(int x) {
        if (p.find(x) == p.end()) {
            p[x] = -1;
            ++sz;
            return x;
        }
        while (p[x] != -1) {
            x = p[x];
        }
        return x;
    }
    
    void uni(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x != y) {
            p[x] = y;
            --sz;
        }
    }
};