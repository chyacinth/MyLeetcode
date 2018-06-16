/*
递归即可
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean dfs(TreeNode left,  TreeNode right) {
        if (left == null || right == null){
            if (right != left) {return false;}
            return true;
        }
        return (left.val == right.val) & dfs(left.left, right.right) & dfs(left.right, right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }
}