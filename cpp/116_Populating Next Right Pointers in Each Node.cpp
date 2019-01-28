/**
 * Simple BFS
 **/ 
class Solution {
public:
    void connect(TreeLinkNode *root) {
        queue<pair<TreeLinkNode*, int>> bfs;
        // root is empty
        if (!root) { return; }
        bfs.push({root, 0});
        while (!bfs.empty()) {
            auto nodep = bfs.front();
            bfs.pop();
            if (bfs.empty() || bfs.front().second != nodep.second) { 
                nodep.first->next = nullptr; 
            } else {
                nodep.first->next = bfs.front().first;
            }
            if (nodep.first->left) {
                bfs.push({nodep.first->left, nodep.second + 1});
            }
            if (nodep.first->right) {
                bfs.push({nodep.first->right, nodep.second + 1});
            }
        }
    }
};