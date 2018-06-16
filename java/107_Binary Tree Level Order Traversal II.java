// dfs，注意左子树和右子树的两个List在合并的时候要右对齐，此时两个List的索引从lenL-lenMax和lenR-lenMax开始
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> resultl, resultr;
        List<List<Integer>> results = new ArrayList<>();
        resultl = levelOrderBottom(root.left);
        resultr = levelOrderBottom(root.right);
        int l = resultl.size(), r = resultr.size();
        int maxL = Math.max(l,r);
        l -= maxL; r -= maxL;
        while ((l >= 0 || r >= 0) && (l < maxL && r < maxL)) {
            if (l < 0) results.add(resultr.get(r));
            else if (r < 0) results.add(resultl.get(l));
            else {
                List<Integer> newList = new ArrayList<>(resultl.get(l));
                newList.addAll(resultr.get(r));
                results.add(newList);
            }
            l += 1;
            r += 1;
        }
        List<Integer> additional = new ArrayList<>();
        additional.add(root.val);
        results.add(additional);
        return results;
    }
}