//使用stack，记录从root到最小节点的路径，next就是stack最后一个元素。
//找到后如果最小元素有右子树，则将右子树最小数的路径加入stack
//如果最小元素没有右子树，则从stack中找父节点，如果父节点.左子树=最小元素，则pop最小元素，如果父节点.右子树=最小元素，则使调用next(父节点)，且父节点.右子树要变为Null
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    TreeNode r = null, rp = null;
    Stack<TreeNode> stack = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        r = root;
        if (r == null) return;
        stack.push(r);
        while (r.left != null) {
            r = r.left;
            stack.push(r);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!stack.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        int retVal = 0;
        if (hasNext()) {
            r = stack.peek();
            retVal = r.val;
            if (r.right != null) {
                r = r.right;
                stack.push(r);
                while (r.left != null) {
                    r = r.left;
                    stack.push(r);
                }
            }
            else {
                r = stack.pop();
                if (!stack.isEmpty()) {
                    rp = stack.peek();
                    if (rp.right == r) {
                        rp.left = null;
                        rp.right = null;
                        next();
                    }
                }
            }
        }     
        return retVal;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */