/**
 * 判断p q是在root的左边还是右边，同侧则继续递归，不同侧返回root
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
        if (root == null) return root;
        if ((p.val <= root.val && q.val >= root.val) || 
            (p.val >= root.val && q.val <= root.val)) {
            return root;
        }
        else {
            if (p.val < root.val) return lowestCommonAncestor(root.left, p, q);
            else return lowestCommonAncestor(root.right, p, q);
        }
    }
}