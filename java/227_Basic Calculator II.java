/**
 * 中缀转前缀
 */
class Solution {
  
  private class Node {
    private boolean isOperator;
    private char operator;
    private int operand;
    Node (boolean isOperator, char operator, int operand) {
      this.isOperator = isOperator;
      this.operator = operator;
      this.operand = operand;
    }
  }
  
  static final Map<Character, Integer> priority = new HashMap<>();
  static {
    priority.put('+', 1);
    priority.put('-', 1);
    priority.put('*', 2);
    priority.put('/', 2);
  }
  
  private int calc(int o1, int o2, char op) {
    switch(op) {
      case '+' :
        return o1 + o2;
      case '-' :
        return o1 - o2;
      case '*' :
        return o1 * o2;
      case '/' :
        return o1 / o2;
    }
    return 0;
  }
  
  public int calculate(String s) {
    int i = 0;
    Deque<Node> post = new ArrayDeque<>();
    Deque<Character> operator = new ArrayDeque<>();
    while (i < s.length()) {
      char ch = s.charAt(i);
      if (Character.isDigit(ch)) {
        int num = Character.getNumericValue(ch);
        while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) { 
          ++i; 
          num = num * 10 + Character.getNumericValue(s.charAt(i));
        }
        post.push(new Node(false, ' ', num));
      } else if (priority.containsKey(ch)) {
        System.out.println(ch);
        while (!operator.isEmpty() && priority.get(ch) <= priority.get(operator.peek())) {
          char top = operator.pop();
          post.push(new Node(true, top, 0));
        }
        operator.push(ch);
      }
      ++i;
    }
    while (!operator.isEmpty()) {
      char top = operator.pop();
      post.push(new Node(true, top, 0));
    }
    System.out.println("----");
    Deque<Integer> results = new ArrayDeque<>();
    while (!post.isEmpty()) {
      Node node = post.removeLast();
      if (!node.isOperator) {
        results.push(node.operand);
      } else {
        int operand2 = results.pop();
        int operand1 = results.pop();
        results.push(calc(operand1, operand2, node.operator));
      }
    }
    return results.getFirst();
  }
}