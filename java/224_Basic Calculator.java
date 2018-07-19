/**
 * 数据结构经典题
 * 维护数字栈和运算符号栈
 * 看到数字，就数字进栈
 * 看到左括号，就左括号进栈
 * 如果我们遇到一个运算符号，且他之前那个符号也是运算符号，则可以使用并弹出之前那个运算符号和数字栈顶的两个数进行计算，再将新的结果和当前
 * 符号入栈
 * 如果遇到右括号，则此时符号栈顶或为(+/-，或为(，如果是第一种情况，则和之前一样，弹出符号进行计算，然后就变成了第二种情况
 * 第二种情况，则直接弹出+/-
 */
class Solution {
    public int calculate(String s) {
        s = s + ")";
        s = s.replaceAll(" ","");        
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        operatorStack.push('(');
        int i = 0;
        while (i < s.length()){
            char ch = s.charAt(i);
            char topOperStack = operatorStack.peek();
            if (ch == '+' || ch == '-') {
                if (topOperStack == '+' || topOperStack == '-') {
                    int op2 = numStack.pop();
                    int op1 = numStack.pop();
                    operatorStack.pop();
                    if (topOperStack == '+') { numStack.push(op1 + op2); }
                    else { numStack.push(op1 - op2); }
                }
                operatorStack.push(ch);
            }
            else if (ch == '(') {
                operatorStack.push(ch);
            }
            else if (ch == ')') {                                
                if (topOperStack == '+' || topOperStack == '-') {                    
                    int op2 = numStack.pop();
                    int op1 = numStack.pop();
                    if (topOperStack == '+') { numStack.push(op1 + op2); }
                    else { numStack.push(op1 - op2); }
                    operatorStack.pop();
                }
                topOperStack = operatorStack.peek();
                if (topOperStack != '(') { return -999; }
                operatorStack.pop();
            }
            else {                
                int st = i;
                while (Character.isDigit(s.charAt(++i))) {}
                int end = i;                
                int number = Integer.valueOf(s.substring(st, end));                
                i -= 1;                
                numStack.push(number);
            }
            i += 1;
        }
    return numStack.peek();
    }
}