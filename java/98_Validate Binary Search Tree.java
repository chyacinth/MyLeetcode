/*
递归判断
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
    public boolean dfs(boolean leftBound, int leftValue, 
                       boolean rightBound, int rightValue, TreeNode root) {
        if (root == null) {return true;}
        int x = root.val;
        if (leftBound && x <= leftValue) {return false;}
        if (rightBound && x >= rightValue) {return false;}
        return dfs(leftBound, leftValue, true, x, root.left) && 
            dfs(true, x, rightBound, rightValue, root.right);
    }
        
    public boolean isValidBST(TreeNode root) {
        return dfs(false, 0, false, 0, root);
    }
}