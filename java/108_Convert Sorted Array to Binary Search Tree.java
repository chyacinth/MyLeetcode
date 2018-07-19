/**
 * 递归就完事了
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
    
    TreeNode buildTree(int[] nums, int st, int end) {
        if (st > end) return null;
        int mid = (st + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, st, mid - 1);
        root.right = buildTree(nums, mid + 1, end);
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return buildTree(nums, 0, nums.length - 1);
    }
}