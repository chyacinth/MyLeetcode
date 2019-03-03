/**
 * Use topology sort to find loops
 */ 
class Solution {
public:
    bool canFinish(int numCourses, vector<pair<int, int>>& prerequisites) {
        vector<vector<int>> link(numCourses);
        vector<int> in_degree(numCourses);
        for (auto [second, first] : prerequisites) {
            link[first].push_back(second);
            ++in_degree[second];
        }
        // topology sort
        queue<int> bfs;
        for (int i = 0; i < numCourses; ++i) {
            if (in_degree[i] == 0) {
                bfs.push(i);
            }
        }
        while (!bfs.empty()) {
            int node = bfs.front();
            bfs.pop();
            for (int out : link[node]) {
                if (--in_degree[out] == 0) {
                    bfs.push(out);
                }
            }
        }
        for (int deg : in_degree) {
            if (deg != 0) return false;
        }
        return true;
    }
};