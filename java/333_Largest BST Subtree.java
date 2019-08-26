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
  
  private class Result {
    private boolean isBst = false;
    private int size = 0;
    private int min;
    private int max;
    Result(boolean isBst, int size, int min, int max) {
      this.isBst = isBst;
      this.size = size;
      this.min = min;
      this.max = max;
    }
  }
  
  private Result helper(TreeNode node) {
    if (node == null) { return new Result(true, 0, 0, 0); }
    if (node.left == null && node.right == null) {
      return new Result(true, 1, node.val, node.val);
    }
    int max = node.val;
    int min = node.val;
    
    boolean leftSatisfy = true;
    boolean rightSatisfy = true;
    
    Result leftRes = new Result(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    if (node.left != null) {
      leftRes = helper(node.left);
      max = Math.max(max, leftRes.max);
      min = Math.min(min, leftRes.min);
      leftSatisfy = leftRes.isBst == true;
      leftSatisfy &= (leftRes.max < node.val);
    }
    
    Result rightRes = new Result(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    if (node.right != null) {
      rightRes = helper(node.right);
      max = Math.max(max, rightRes.max);
      min = Math.min(min, rightRes.min);
      rightSatisfy = rightRes.isBst == true;
      rightSatisfy &= (rightRes.min > node.val);
    }

    if (leftSatisfy && rightSatisfy) {
      return new Result(true, 1 + leftRes.size + rightRes.size,
                       min, max);
    } else {
      return new Result(false, Math.max(Math.max(leftRes.size, rightRes.size), 1), 0, 0);
    }
  }
  
  public int largestBSTSubtree(TreeNode root) {
    Result res = helper(root);
    return res.size;
  }
}