/*
递归转迭代的经典做法
需要我们为每次递归中函数调用划分成几块，用cnt来判断运行哪块
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
    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return result;
        List<TreeNode> stack = new ArrayList<TreeNode>();
        List<Integer> stackCnt = new ArrayList<Integer>();
        stack.add(root);
        stackCnt.add(0);
        while (stack.size() > 0) {
            TreeNode node = stack.get(stack.size() - 1);
            int cnt = stackCnt.get(stackCnt.size() - 1);
            stackCnt.set(stackCnt.size() - 1, cnt + 1);
            cnt += 1;
            if (cnt == 1) {
                if (node.left != null) {
                    stack.add(node.left); 
                    stackCnt.add(0); 
                }
            } else {
                result.add(node.val);
                stack.remove(stack.size() - 1);
                stackCnt.remove(stackCnt.size() - 1);
                if (node.right != null) {
                    stack.add(node.right); 
                    stackCnt.add(0); 
                }
            }                
        }
        return result;
    }
}