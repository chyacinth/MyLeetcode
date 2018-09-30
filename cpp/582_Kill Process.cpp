class Solution {
public:
    void killProcessHelper(int kill, unordered_map<int, vector<int>> &children, vector<int> &results) {
        for (int &child : children[kill]) {
            killProcessHelper(child, children, results);
        }
        results.push_back(kill);
    }
    vector<int> killProcess(vector<int>& pid, vector<int>& ppid, int kill) {
        int node_num = pid.size();
        unordered_map<int, vector<int>> children;
        vector<int> results;
        for (int i = 0; i < node_num; ++i) {
          children[ppid[i]].push_back(pid[i]);
        }
        killProcessHelper(kill, children, results);
        return results;
    }
};