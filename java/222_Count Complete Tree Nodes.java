/**
 * 有更加厉害的做法：
 * 判断右子树高度（高度计算O(lgN)）是不是根节点高度-1，如果是，则左子树为满二叉树，加上左子树的数量，然后切换到右子树，继续。
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
    public boolean findNthInFinalLayer(TreeNode root, int n, int total, int depth) {
        TreeNode p = root;
        for (int i = 0; i < depth; ++i) {
            if (n <= total / 2) {
                p = p.left;
            } else {
                p = p.right;
                n = n - total / 2 - 1;
            }
            total = total / 2;
        }
        if (p != null) return true;
        else return false;
    }
    public int countNodes(TreeNode root) {
        TreeNode node = root;
        int result = 0;
        int depth = 0;
        int num = 1;
        while (node != null) {
            result += num;
            num *= 2;
            depth += 1;
            node = node.right;
        }
        int maxNumInFinalLayer = -1;
        int lastLayerTotal = (int)Math.pow(2, depth);        
        int l = 0;
        int r = lastLayerTotal - 1;        
        while (l <= r) {
            int mid = (l + r) / 2;
            if (findNthInFinalLayer(root, mid, lastLayerTotal - 1, depth)) {
                maxNumInFinalLayer = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }        
        return result + maxNumInFinalLayer + 1;
    }
}