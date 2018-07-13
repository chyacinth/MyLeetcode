/**
 * 递归算高度就完事了
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
    public int depth(TreeNode root) {
        if (root == null) return 0;
        int l = depth(root.left);
        int r = depth(root.right);
        if (l == -1 || r == -1) return -1;
        if (Math.abs(l - r) <= 1) return Math.max(l, r) + 1;
        return -1;
    }
    public boolean isBalanced(TreeNode root) {
        return ! (depth(root) == -1);
    }
}