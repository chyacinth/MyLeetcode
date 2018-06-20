/*
逆波兰式……数据结构经典题目
栈
*/
class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int s1, s2;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                s2 = stack.pop();
                s1 = stack.pop();
                stack.push(s1 + s2);
            }
            else if (tokens[i].equals("-")) {
                s2 = stack.pop();
                s1 = stack.pop();
                stack.push(s1 - s2);
            }
            else if (tokens[i].equals("*")) {
                s2 = stack.pop();
                s1 = stack.pop();
                stack.push(s1 * s2);
            }
            else if (tokens[i].equals("/")) {
                s2 = stack.pop();
                s1 = stack.pop();
                stack.push(s1 / s2);
            }
            else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return (stack.pop());
    }    
}