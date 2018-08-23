/**
 * 递归，simple
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new ArrayList<>();
        if (root == null) {            
            return results;
        } else {            
            List<String> subResults = binaryTreePaths(root.left);
            for (String subResult : subResults) {                
                results.add(String.valueOf(root.val) + "->" + subResult);                              
            }
            subResults = binaryTreePaths(root.right);
            for (String subResult : subResults) {                
                results.add(String.valueOf(root.val) + "->" + subResult);                
            }
            if (root.left == null && root.right == null) {
                results.add(String.valueOf(root.val));    
            }
        }
        return results;
    }
}