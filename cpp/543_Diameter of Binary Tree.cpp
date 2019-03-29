/**
 * 简单递归
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
    int longest_path(TreeNode* root) 
    {
        if (!root) {
            return 0;
        }
        int left_num = 0;
        int right_num = 0;
        if (root->left) {
            left_num = longest_path(root->left);
        }
        if (root->right) {
            right_num = longest_path(root->right);
        }
        result = max(result, left_num + 1 + right_num);
        return max(left_num + 1, right_num + 1);
    }
    
    int diameterOfBinaryTree(TreeNode* root) 
    {
        int _ = longest_path(root);
        return result - 1;
    }
private:
    int result = 1;
};