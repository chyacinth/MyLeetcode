/**
 * Simple
 **/ 
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
  void find_leaves(TreeNode* root, vector<TreeNode*>& leaves) {
    if (root) {
      if (!root->left && !root->right) {
        leaves.push_back(root);
      } else {
        if (root->left) {
          find_leaves(root->left, leaves);
        }
        if (root->right) {
          find_leaves(root->right, leaves);
        }
      }
    }
  }
  
  vector<int> boundaryOfBinaryTree(TreeNode* root) {
    TreeNode* temp_root = root;
    vector<TreeNode*> left_bound;
    // left bound
    while (temp_root) {
      left_bound.push_back(temp_root);
      if (temp_root->left)
        temp_root = temp_root->left;
      else if (temp_root == root)
        break;
      else
        temp_root = temp_root->right;
    }
    
    // leaves
    vector<TreeNode*> leaves;
    find_leaves(root, leaves);
    
    temp_root = root;
    vector<TreeNode*> right_bound;
    // right bound
    while (temp_root) {      
      right_bound.push_back(temp_root);
      if (temp_root->right)
        temp_root = temp_root->right;
      else if (temp_root == root)
        break;
      else
        temp_root = temp_root->left;
    }
    
    vector<int> results;
    for (auto node : left_bound) {
      results.push_back(node->val);
    }
    for (auto node : leaves) {      
      if (node != left_bound[left_bound.size() - 1])
        results.push_back(node->val);
    }
    for (auto node = right_bound.rbegin(); node != right_bound.rend(); ++node) {
      
      if (*node != leaves[leaves.size() - 1] && *node != left_bound[0])
        results.push_back((*node)->val);
    }
    return results;
  }
};