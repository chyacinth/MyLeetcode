//BFS
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
    public List<List<Integer>> levelOrder(TreeNode root) {       
        List<List<Integer>> results = new ArrayList<>();  
        if (root == null) return results;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);        
        int cur = 0;
        TreeNode curNode = null;
        
        while (cur < list.size()) {
            int size = list.size();
            List<Integer> result = new ArrayList<>();
            int i;
            for (i = cur; i < size; i++) {
                curNode = list.get(i);
                if (curNode.left != null) list.add(curNode.left);
                if (curNode.right != null) list.add(curNode.right);
                result.add(curNode.val);
            }
            cur = size;
            results.add(result);            
        }        
        return results;
    }    
}