/*
转化为leetcode84，对第0到i行形成的heights矩阵求最大矩形
*/
class Solution {
    static class MyStack {
        int[] stack;
        int len;
        public MyStack(int n) {
            stack = new int[n];
        }
        public boolean isEmpty(){
            return (len == 0);
        }
        public void push(int x) {
            stack[len] = x;
            len += 1;
        }
        public int pop() {
            len -= 1;
            return (stack[len]);
        }
        public int peek() {
            return (stack[len - 1]);
        }
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, result = 0;
        MyStack stack = new MyStack(n);
        MyStack stack2 = new MyStack(n);
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
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        if (matrix[0].length == 0) return 0;
        int n = matrix.length, m = matrix[0].length, result = 0;
        int[] heights = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                }
                else {heights[j] = 0;}
            }
            result = Math.max(largestRectangleArea(heights), result);
        }
        return result;
    }    
}