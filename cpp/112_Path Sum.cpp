/**
 * Easy
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
    bool hasPathSum(TreeNode* root, int sum) {
        if (!root) return false;
        bool result = false;
        if (root->left) result |= hasPathSum(root->left, sum - root->val);
        if (root->right) result |= hasPathSum(root->right, sum - root->val);
        if (!root->left && !root->right) result |= (root->val == sum);
        return result;
    }
};