/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */
class Solution {
public:
    void connect(TreeLinkNode *root) {
        if (root == NULL) return;
        queue<pair<TreeLinkNode*, int>> bfs_queue;
        bfs_queue.push({root, 1});
        int level = 0;
        while (!bfs_queue.empty()) {
            ++level;
            TreeLinkNode *prev = NULL;
            while (!bfs_queue.empty() && bfs_queue.front().second == level) {
                auto node = bfs_queue.front();
                bfs_queue.pop();
                if (prev != NULL) { 
                    prev->next = node.first;                     
                }
                prev = node.first;
                if (node.first->left != NULL) { bfs_queue.push({node.first->left, node.second + 1}); }
                if (node.first->right != NULL) { bfs_queue.push({node.first->right, node.second + 1}); }
            }
            if (prev != NULL) { 
                prev->next = NULL;
            }                        
        }
    }
};