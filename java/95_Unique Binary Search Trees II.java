/*
简单dfs,枚举根节点，dfs搜索子树的结果
注意n=0是单独返回空列表
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
    public List<TreeNode> dfs(int st, int ed) {
        List<TreeNode> result = new ArrayList<TreeNode>();        
        if (st > ed) {
            result.add(null);
            return result;
        } else if (st == ed) {
            result.add(new TreeNode(st));
            return result;
        } else {
            for (int i = st; i <= ed; i++) {
                List<TreeNode> leftResult = dfs(st, i - 1);
                List<TreeNode> rightResult = dfs(i + 1, ed);
                for (int j = 0; j < leftResult.size(); j++) {
                    for (int k = 0; k < rightResult.size(); k++) {
                        TreeNode root =new TreeNode(i);
                        root.left = leftResult.get(j);
                        root.right = rightResult.get(k);
                        result.add(root);
                    }
                }
            }
            return result;
        }
    }
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return dfs(1, n);
    }
}