/**
 * 考察问题是否有递归结构
 * 对于一个节点，它的左子树一定会给他左子树金币数-左子树节点数个金币。右子树同理。搞定
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
    
    private int result = 0;
    
    private Map<TreeNode, Integer> nodeToCoins = 
        new HashMap<>();
    private Map<TreeNode, Integer> nodeToNum = 
        new HashMap<>();
    
    private void countNodes(TreeNode root) {
        int coins = root.val;
        int nodeNum = 1;
        
        if (root.left != null) {
            countNodes(root.left);
            coins += nodeToCoins.get(root.left);
            nodeNum += nodeToNum.get(root.left);
        }
        if (root.right != null) {
            countNodes(root.right);
            coins += nodeToCoins.get(root.right);
            nodeNum += nodeToNum.get(root.right);
        }
        nodeToCoins.put(root, coins);
        nodeToNum.put(root, nodeNum);
    }
    
    private void dfs(TreeNode root) {
        if (root.left != null) {
            TreeNode left = root.left;
            int rootToLeft = nodeToNum.get(left) - nodeToCoins.get(left);
            result += Math.abs(rootToLeft);
            dfs(root.left);
        }
        if (root.right != null) {
            TreeNode right = root.right;
            int rootToRight = nodeToNum.get(right) - nodeToCoins.get(right);
            result += Math.abs(rootToRight);
            dfs(root.right);
        }
    }
    
    public int distributeCoins(TreeNode root) {
        countNodes(root);
        dfs(root);
        return result;
    }
}