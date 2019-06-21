/**
 * 贪心。对于字符串前k+1个，必须移调最小值前面的所有才能保证最小。如果最小值是第一个，那么就看从第2个开始的k+1个中最小
 * 因此可以用滑动窗口。而滑动窗口+最小值，就是标准的单调队列的解题思路了。
 */
class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) { return "0"; }
        Deque<Integer> monoStack = new ArrayDeque<>();
        for (int i = 0; i <= k; ++i) {            
            int digit = num.charAt(i) - '0';            
            while (!monoStack.isEmpty() && monoStack.peek() > digit) {
                monoStack.pop();                    
            }
            monoStack.push(digit);
        }        
        StringBuilder sb = new StringBuilder();
        for (int i = k + 1; i < num.length(); ++i) {
            int digit = num.charAt(i) - '0';            
            sb.append(monoStack.pollLast());                
            while (!monoStack.isEmpty() && monoStack.peek() > digit) {
                monoStack.pop();
            }
            monoStack.push(digit);
        }
        Iterator<Integer> it = monoStack.descendingIterator();        
        if (it.hasNext()) { sb.append(it.next()); }
        int i = 0;
        while (i < sb.length() - 1 && sb.charAt(i) == '0') {
            ++i;
        }        
        return sb.toString().substring(i, sb.length());
    }
}