/**
 * 递归
 * 左边flatten，右边flatten，再拼起来。
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
    public TreeNode flattenRecursive(TreeNode root) {
        if (root == null) { return root; }
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode leftRet = flattenRecursive(left);
        TreeNode rightRet = flattenRecursive(right);
        if (left != null) {
            root.right = left;
            root.left = null;
            leftRet.right = right;
        } else {
            root.right = right;
            root.left = null;
        }
        if (rightRet != null) { return rightRet; }
        if (leftRet != null) { return leftRet; }
        return root;
    }
    public void flatten(TreeNode root) {
        flattenRecursive(root);
    }
}