/**
 * O(N)空间复杂度的解法比较容易，另开一个O(N)的栈来维护插入过程中每个阶段的最小值即可
 * 如果执意要求O(1)空间复杂度的就比较麻烦。需要在一个栈中存放当前最小值和插入元素的差值。而当插入的元素为新的最小值时，栈中保存到则是
 * 新的最小值和旧最小值的差值，以便在pop()时可以追踪不同阶段的最小值。然后插入、弹出和peek的时候根据栈中元素正负值决定如何计算
 */
class MinStack {
    private List<Long> minStack;
    long minVal = 0;
    
    /** initialize your data structure here. */
    public MinStack() {
        minStack = new ArrayList<>();
    }
    
    public void push(int x) {
        long tx = Long.valueOf(x);
        if (minStack.isEmpty()){
            minVal = tx;
        }
        
        minStack.add(minVal - tx);
        
        if (minVal > tx) minVal = tx;
    }
    
    public void pop() {
        long lastVal = minStack.get(minStack.size() - 1);        
        if (lastVal > 0)
            minVal += lastVal;                    
        minStack.remove(minStack.size() - 1);
    }
    
    public int top() {
        long lastVal = minStack.get(minStack.size() - 1);
        if (lastVal > 0) {
            return Math.toIntExact(minVal);
        }
        else {
            return Math.toIntExact((minVal - lastVal));
        }
    }
    
    public int getMin() {
        return Math.toIntExact(minVal);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */