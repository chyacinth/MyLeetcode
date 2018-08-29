/**
 * First find the maximum depth.
 * Then use dfs to calculate the weight sum
 * Instead of using vector<NestedInteger>& nestedList,
 * use NestedInteger nestedList will make the code cleaner.
 */ 
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *   public:
 *     // Constructor initializes an empty nested list.
 *     NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     NestedInteger(int value);
 *
 *     // Return true if this NestedInteger holds a single integer, rather than a nested list.
 *     bool isInteger() const;
 *
 *     // Return the single integer that this NestedInteger holds, if it holds a single integer
 *     // The result is undefined if this NestedInteger holds a nested list
 *     int getInteger() const;
 *
 *     // Set this NestedInteger to hold a single integer.
 *     void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     void add(const NestedInteger &ni);
 *
 *     // Return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     const vector<NestedInteger> &getList() const;
 * };
 */
class Solution {
public:
  int depthSumInverse(vector<NestedInteger>& nestedList) {
    NestedInteger nested_list;
    for (auto&& nested_int : nestedList) {
      nested_list.add(nested_int);
    }    
    int max_depth = findDepth(nested_list);
    int result = depthSumInverseHelper(nested_list, 1, max_depth);
    return result;
  }
  int findDepth(NestedInteger& nested_list) {
    if (nested_list.isInteger()) {
      return 1;
    } else {
      int max_depth = 0;
      for (auto&& nested_int : nested_list.getList()) {
        max_depth = max(max_depth, findDepth(nested_int) + 1);        
      }
      return max_depth;
    }
  }
  int depthSumInverseHelper(NestedInteger& nested_list, int current_depth, int max_depth) {
    if (nested_list.isInteger()) {
      return (max_depth - current_depth + 1) * nested_list.getInteger();
    } else {
      int result = 0;
      for (auto&& nested_int : nested_list.getList()) {
        result += depthSumInverseHelper(nested_int, current_depth + 1, max_depth);
      }
      return result;
    }
  }
};