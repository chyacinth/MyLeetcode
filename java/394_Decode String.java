/**
 * 堆栈，而且是最符合人直观最简单的那种方法，虽然时间复杂度高点。。
 */
class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();        
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == ']') {
                StringBuilder sb = new StringBuilder();                
                char chPoped;
                while (stack.peek() != '[') {
                    chPoped = stack.pop();
                    sb.append(chPoped);                    
                }
                stack.pop();
                sb.reverse();
                StringBuilder repeatStr = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {                    
                    chPoped = stack.pop();
                    repeatStr.append(chPoped);
                }
                int repeatNum = Integer.valueOf(repeatStr.reverse().toString());
                for (int t = 0; t < repeatNum; ++t) {
                    for (int j = 0; j < sb.length(); ++j) {
                        stack.push(sb.charAt(j));
                    }
                }
            }
            else {
                stack.push(ch);                
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}