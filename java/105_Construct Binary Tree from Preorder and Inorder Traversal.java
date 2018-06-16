//递归，经典题
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if ((preorder.length > 0) && (inorder.length > 0)) {
            TreeNode ln, rn, rt;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == preorder[0]) {
                    int[] pre = Arrays.copyOfRange(preorder, 1, 1 + i);
                    int[] ino = Arrays.copyOfRange(inorder, 0, i);
                    ln = buildTree(pre, ino);
                    pre = Arrays.copyOfRange(preorder, 1 + i, preorder.length);
                    ino = Arrays.copyOfRange(inorder, 1 + i, inorder.length);
                    rn = buildTree(pre, ino);
                    rt = new TreeNode(preorder[0]);
                    rt.left = ln;
                    rt.right = rn;
                    return rt;
                }
            }
            return null;
        }
        else return null;
    }
}