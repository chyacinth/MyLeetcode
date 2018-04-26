/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSumRecursion(List<NestedInteger> nestedList, int depth) {
        int cnt = 0;
        for (int i = 0; i < nestedList.size(); i++) {
            if (nestedList.get(i).isInteger()) {
                cnt += depth * nestedList.get(i).getInteger();
            } else {
                cnt += depthSumRecursion(nestedList.get(i).getList(), depth + 1);
            }
        }
        return cnt;
    }
    public int depthSum(List<NestedInteger> nestedList) {
        // Write your code here
        return depthSumRecursion(nestedList, 1);
    }
}