/**
 * Use BFS to iterate each node.
 * Keep the col of each node, and add (col, node) pair to a map
 * add each pair from map to the result
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
  vector<vector<int>> verticalOrder(TreeNode* root) {
    queue<pair<TreeNode*, int>> bfs_queue;
    bfs_queue.push({root, 0});
    while (!bfs_queue.empty()) {
      TreeNode* root = bfs_queue.front().first;
      int col = bfs_queue.front().second;
      bfs_queue.pop();
      if (root == nullptr) continue;
      col_to_nodes_[col].push_back(root->val);
      if (left_bound_ > col) { left_bound_ = col; }
      if (right_bound_ < col) { right_bound_ = col; }
      if (root->left != nullptr) {
        bfs_queue.push({root->left, col - 1});
      }    
      if (root->right != nullptr) {
        bfs_queue.push({root->right, col + 1});
      }
    }
    for (int i = left_bound_; i <= right_bound_; ++i) {
      vector<int> result;
      for (auto &&num : col_to_nodes_[i]) {
        result.push_back(num);
      }
      if (!result.empty()) results_.push_back(move(result));
    }
    return results_;
  }
private:
  int left_bound_ = 0;
  int right_bound_ = 0;
  unordered_map<int, vector<int>> col_to_nodes_;
  vector<vector<int>> results_;
};