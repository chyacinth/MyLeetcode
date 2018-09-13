/**
 * Use BFS for traversing the node from top to bottom and
 * record the layer of each node.
 * Then only store the node the layer of which appears in the 
 * first time.
 */ 
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
  vector<int> rightSideView(TreeNode* root) {
    queue<pair<TreeNode*, int> > queue;
    queue.push({root, 0});
    vector<int> result;
    if (root == nullptr) { return result; }
    result.push_back(root->val);    
    while (!queue.empty()) {
      TreeNode* current_node = queue.front().first;
      int layer = queue.front().second;
      queue.pop();
      if (current_node == nullptr) { continue; }
      if (layer >= result.size()) {
        result.push_back(current_node->val);
      }
      queue.push({current_node->right, layer + 1});
      queue.push({current_node->left, layer + 1});
    }
    return result;
  }
};