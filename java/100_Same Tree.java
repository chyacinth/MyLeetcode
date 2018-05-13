/*
要时间最快，应该先判断当前两个节点的值是否相等然后再判断左子树和右子树是否相等
这样可以少递归
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean leftSame = false, rightSame = false;
        if (p == null && q == null) {return true;}
        else if (p == null || q == null) {return false;}                    
        if (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
            return true;
        }
        return false;
    }
}