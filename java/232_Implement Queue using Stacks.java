/**
 * 两个stack就完事了
 */
class MyQueue {    
    Stack<Integer> lStack;
    Stack<Integer> rStack;
    /** Initialize your data structure here. */
    public MyQueue() {
        lStack = new Stack<>();
        rStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!lStack.isEmpty()) {
            int temp = lStack.pop();
            rStack.push(temp);
        }
        lStack.push(x);
        while (!rStack.isEmpty()) {
            int temp = rStack.pop();
            lStack.push(temp);
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (lStack.isEmpty()) return 0;
        return lStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (lStack.isEmpty()) return 0;
        return lStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return lStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */