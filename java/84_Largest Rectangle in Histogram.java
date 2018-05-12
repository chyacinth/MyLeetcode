/*
leetcode 84: 
什么是单调栈：栈中的元素都递增或递减，push之前会先pop出所有比当前元素大的元素
单调栈性质：使用单调栈可以找到元素向左遍历第一个比他小的元素，也可以找到元素向左遍历第一个比他大的元素。
使用该性质可以很简单地解决这题~
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, result = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int[] maxLeft = new int[n], maxRight = new int[n];
        Arrays.fill(maxLeft, 0);
        Arrays.fill(maxRight, 0);
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                maxLeft[i] = (i + 1) * heights[i];
            }
            else {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {                    
                    maxLeft[i] = (i + 1) * heights[i];
                } else {
                    maxLeft[i] = (i - stack.peek()) * (heights[i]);
                }
                stack.push(i);
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            if (stack2.isEmpty()) {
                stack2.push(i);
                maxRight[i] = (n - i) * heights[i];
            }
            else {
                while (!stack2.isEmpty() && heights[stack2.peek()] >= heights[i]) {
                    stack2.pop();
                }
                if (stack2.isEmpty()) {                    
                    maxRight[i] = (n - i) * heights[i];
                } else {
                    maxRight[i] = (stack2.peek() - i) * (heights[i]);
                }
                stack2.push(i);
            }
        }
        for (int i = 0; i < n; i++) {
            result = Math.max(result, maxLeft[i] + maxRight[i] - heights[i]);
        }
        return result;
    }
}