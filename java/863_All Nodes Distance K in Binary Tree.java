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
    private static class GNode {
        private int val = 0;
        private GNode parent = null;
        private GNode left = null;
        private GNode right = null;
    }
    
    private GNode start;
    private Set<GNode> visited = new HashSet<>();
    private Queue<GNode> queue = new LinkedList<>();
    
    private GNode buildGraph(TreeNode root, TreeNode target) {
        GNode rootGNode = new GNode();
        rootGNode.val = root.val;
        if (root.left != null) {
            rootGNode.left = buildGraph(root.left, target);
            rootGNode.left.parent = rootGNode;
        }
        if (root.right != null) {
            rootGNode.right = buildGraph(root.right, target);
            rootGNode.right.parent = rootGNode;
        }
        if (root == target) {
            start = rootGNode;
        }
        return rootGNode;
    }
    
    private void bfs (GNode start, int k, List<Integer> result) {
        queue.offer(start);
        visited.add(start);
        while (k > 0) {
            int sz = queue.size();
            for (int i = 0; i < sz; ++i) {
                GNode popNode = queue.poll();
                if (popNode.parent != null && 
                    !visited.contains(popNode.parent)) {
                    visited.add(popNode.parent);
                    queue.offer(popNode.parent);
                }
                if (popNode.left != null && 
                    !visited.contains(popNode.left)) {
                    visited.add(popNode.left);
                    queue.offer(popNode.left);
                }
                if (popNode.right != null && 
                    !visited.contains(popNode.right)) {
                    visited.add(popNode.right);
                    queue.offer(popNode.right);
                }
            }
            k -= 1;
        }
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
        
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        
        buildGraph(root, target);
        List<Integer> result = new ArrayList<>();
        bfs(start, K, result);
        return result;
    }
}