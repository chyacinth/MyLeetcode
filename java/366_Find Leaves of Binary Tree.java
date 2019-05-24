/**
 * 简单递归
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
    
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public int findLeavesHelper(TreeNode root) {
        if (root == null) {{ return -1; }}
        
        int prevIdx = Math.max(findLeavesHelper(root.left), findLeavesHelper(root.right));            
        while (result.size() < prevIdx + 2) {
            result.add(new ArrayList<Integer>());
        }
        result.get(prevIdx + 1).add(root.val);
        
        return prevIdx + 1;
    }
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        findLeavesHelper(root);
        return result;
    }
}