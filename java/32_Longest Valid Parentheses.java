class Solution {
    class Node {
        int loc;
        char c;
        Node(int loc, char c) {
            this.loc = loc;
            this.c = c;
        }
    }
    
    public int longestValidParentheses(String s) {
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(new Node(-1, ')'));
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(new Node(i, c));
            } else {
                if (stack.peek().c == '(') {
                    stack.pop();
                    result = Math.max(result, i - stack.peek().loc);
                } else {
                    stack.push(new Node(i, c));
                }
            }
        }
        return result;
    }
}