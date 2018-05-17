/*
dfs
两种情况：
1. 如果交换的两个节点没有祖父-子关系， 则找到他们的公共节点。 怎样找？满足左边最大值>右边最大值的节点中最上层的即可
2. 如果交换的两个节点有祖父-子关系，则找到他们的公共节点（祖父节点、两者之一的那个）。怎样找？满足该节点的值<左边最大值或该节点的值>右边最小值
为什么这样找？因为这是BST交换一对节点后会呈现的性质。
扩展：交换两对节点会怎么样？
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
    TreeNode node1 = null, node2 = null;
    static class RetType {
        TreeNode min = null;
        TreeNode max = null;                
        RetType(TreeNode min_, TreeNode max_) {
            min = min_;
            max = max_;            
        }
    }
    
    RetType dfs(TreeNode root) {
        TreeNode leftMin, leftMax, rightMin, rightMax;
        RetType retVal;       
        TreeNode minN = root, maxN = root;
        if (root.left != null) {
            retVal = dfs(root.left);
            leftMin = retVal.min;
            leftMax = retVal.max;            
        } else {leftMin = leftMax = root;}        
        if (root.right != null) {
            retVal = dfs(root.right);            
            rightMin = retVal.min;
            rightMax = retVal.max;            
        } else {rightMin = rightMax = root;}        
        if (leftMin.val < root.val) minN= leftMin;
        if (rightMax.val > root.val) maxN = rightMax;
        if (leftMax.val >= rightMin.val && leftMax != rightMin) {
            node1 = leftMax;
            node2 = rightMin;
            if (rightMin.val < minN.val) minN = rightMin;
            if (leftMax.val > maxN.val) maxN = leftMax;
        }
        else if (root.val > rightMin.val) {
            node1 = root;
            node2 = rightMin;            
            if (rightMin.val < minN.val) minN = rightMin;            
        }
        else if (root.val < leftMax.val) {
            node1 = root;
            node2 = leftMax;                        
            if (leftMax.val > maxN.val) maxN = leftMax;
        }
        
        return new RetType(minN, maxN);
    }
    public void recoverTree(TreeNode root) {
        RetType retVal = dfs(root);        
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;        
    }
}