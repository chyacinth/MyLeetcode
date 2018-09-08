/**
 * Easy recursive. The helper function returns -1 if found,
 * returns the size of the tree from root else.
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
  int kthSmallest(TreeNode* root, int k) {
    helper(root, k);
    return result;
  }
  int helper(TreeNode* root, int k) {
    if (root == nullptr) { return 0; }
    else if (root->left == nullptr && root->right == nullptr) {
      if (k == 1) {
        result = root->val;
        return -1;
      }
      return 1;
    } else {
      int left_size = 0;
      int right_size = 0;
      if (root->left) {
        left_size = helper(root->left, k);        
        if (left_size == -1) { 
          return -1; 
        }        
      } 
      if (left_size + 1 == k) { 
        result = root->val;
        return -1;
      }
      if (root->right) {        
        right_size = helper(root->right, k - left_size - 1);        
        if (right_size == -1) {
          return -1;
        }
      }
      return left_size + right_size + 1;
    }
  }
private:
  int result = 0;
};