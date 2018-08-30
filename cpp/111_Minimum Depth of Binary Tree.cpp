/**
 * Simple DFS. Pay attention that if the node is not leaf node,
 * we cannot return the min value of the left and the right
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
  int minDepth(TreeNode* root) {
    if (root == NULL) { return 0; }
    if (root->left == NULL) { return minDepth(root->right) + 1; }
    if (root->right == NULL) { return minDepth(root->left) + 1; }
    return min(minDepth(root->left), minDepth(root->right)) + 1;
  }
};