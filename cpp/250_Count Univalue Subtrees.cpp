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
  pair<bool, int> dfs(TreeNode* root, int& cnt) {
    bool left_uni = true;
    int left_num = root->val;
    bool right_uni = true;
    int right_num = root->val;
    if (root->left) {
      auto res = dfs(root->left, cnt);
      left_uni = res.first;
      if (left_uni) {
        left_num = res.second;
      }
    }
    
    if (root->right) {
      auto res = dfs(root->right, cnt);
      right_uni = res.first;
      if (right_uni) {
        right_num = res.second;
      }
    }
    
    if (left_uni && right_uni && left_num == root->val && right_num == root->val) {
      ++cnt;
      return make_pair(true, root->val);
    }
    return make_pair(false, root->val);
  }
  int countUnivalSubtrees(TreeNode* root) {
    if (!root) {
      return 0;
    }
    int cnt = 0;
    dfs(root, cnt);
    return cnt;
  }
};