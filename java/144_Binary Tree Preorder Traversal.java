/**
 * Use stack to simulate DFS
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
    static class RecursiveNode {
        TreeNode node;
        int stage = 0;
        RecursiveNode(TreeNode node, int stage) {
            this.node = node;
            this.stage = stage;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {        
        Stack<RecursiveNode> stack = new Stack<>();
        stack.push(new RecursiveNode(root, 0));
        List<Integer> results = new ArrayList<Integer>();
        if (root == null) { return results; }
        while (!stack.isEmpty()) {
            RecursiveNode currentNode = stack.pop();            
            TreeNode rt = currentNode.node;
            if (currentNode.stage == 0) {
                results.add(currentNode.node.val);
                ++currentNode.stage;
                stack.push(currentNode);
                if (rt.left != null) {                
                    stack.push(new RecursiveNode(rt.left, 0));                
                }
            } else if (currentNode.stage == 1 && rt.right != null) {
                stack.push(new RecursiveNode(rt.right, 0));
            }
        }
        return results;
    }
}