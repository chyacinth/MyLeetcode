//BFS, cnt记录左到右还是右到左，使用LinkedList
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();  
        if (root == null) return results;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);        
        int cur = 0;
        TreeNode curNode = null;
        int cnt = 0;
        while (cur < list.size()) {
            cnt += 1;
            int size = list.size();
            LinkedList<Integer> result = new LinkedList<>();
            int i;            
            for (i = cur; i < size; i++) {
                curNode = list.get(i);
                if (curNode.left != null) list.add(curNode.left);
                if (curNode.right != null) list.add(curNode.right);
                if (cnt % 2 == 1)
                    result.add(curNode.val);
                else
                    result.addFirst(curNode.val);
            }            
            cur = size;
            results.add(result);
        }        
        return results;
    }
}