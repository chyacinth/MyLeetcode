/**
 * Simple in-order traverse of the tree. Don' t know why it is labeled hard
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
  void helper(TreeNode* root, double target, int k) {
    if (root == nullptr) {
      return;
    }
    helper(root->left, target, k);
    if (result_deque_.size() < k) {
      result_deque_.push_back(root->val);
    } else {
      if (abs(result_deque_.front() - target) > abs(root->val - target)) {
        result_deque_.pop_front();
        result_deque_.push_back(root->val);
      }
    }
    helper(root->right, target, k);
  }
  vector<int> closestKValues(TreeNode* root, double target, int k) {
    helper(root, target, k);
    vector<int> result(result_deque_.begin(), result_deque_.end());
    return result;
  }
 private:
  deque<int> result_deque_;
};