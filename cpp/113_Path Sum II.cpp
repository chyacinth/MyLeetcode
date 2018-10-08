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
    void pathSumHelper(TreeNode* root, 
                       vector<int> &current_path, vector<vector<int>> &results, 
                       int sum, int target_sum) {
        if (root == NULL) return;        
        sum += root->val;
        if (root->left != NULL) {
            current_path.push_back(root->val);
            pathSumHelper(root->left, current_path, results, sum, target_sum);
            current_path.pop_back();
        }
        if (root->right != NULL) {
            current_path.push_back(root->val);
            pathSumHelper(root->right, current_path, results, sum, target_sum);
            current_path.pop_back();
        }
        if (sum == target_sum && root->left == NULL && root->right == NULL) {
            current_path.push_back(root->val);
            results.push_back(current_path);
            current_path.pop_back();
        }     
    }
    
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<vector<int>> results;
        vector<int> current_path;
        pathSumHelper(root, current_path, results, 0, sum);
        return results;
    }
};