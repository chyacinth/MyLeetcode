/*
dfs函数返回值为以root为起点的最大path sum
每次dfs中将左右子树的path sum(如果大于零！重要！！) 和 root.val求和与result比较
返回值即为以左右子节点为起点的path sum中大的那个（且要大于0！！重要！！，如果都小于0就不要加）
和root.val之和
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
    public int result = 0;
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftVal = dfs(root.left);
        int rightVal = dfs(root.right);
        int total = root.val;
        if (leftVal > 0) total += leftVal;
        if (rightVal > 0) total += rightVal;
        if (result < total) result = total;
        int retVal = root.val;
        if (leftVal > 0 || rightVal > 0) retVal += Math.max(leftVal, rightVal);
        return (retVal);
    }
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        result = root.val;
        int tmp = dfs(root);
        return result;
    }
}