/**
 * 定义：lowestCommonAncestor函数如果只找到一个节点，则返回这个节点
 * 则，如果p,q都在树root的左子树，则LCA就是roo左子树，反之亦然
 * 而如果p,q各自出现在root的两个子树，则LCA就是root
 * 如果root就是p或q,则返回root
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (root == p | root == q) { return root; }
        if (left == null) { return right; }
        if (right == null) { return left; }
        return root;
    }
}