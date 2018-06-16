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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if ((postorder.length > 0) && (inorder.length > 0)) {
            TreeNode ln, rn, rt;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == postorder[postorder.length - 1]) {                    
                    int[] ino = Arrays.copyOfRange(inorder, 0, i);
                    int[] post = Arrays.copyOfRange(postorder, 0, i);
                    ln = buildTree(ino, post);                    
                    ino = Arrays.copyOfRange(inorder, 1 + i, inorder.length);
                    post = Arrays.copyOfRange(postorder, i, postorder.length - 1);
                    rn = buildTree(ino, post);
                    rt = new TreeNode(postorder[postorder.length - 1]);
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