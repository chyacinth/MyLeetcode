class MyCircularQueue {

    /** Initialize your data structure here. Set the size of the queue to be k. */
    private int[] queue;
    private int front = 0;
    private int rear = 0;
    private int size = 0;
    private int capacity = 0;
    
    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.capacity = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (size + 1 <= capacity) {
            ++size;
            queue[rear++] = value;
            rear %= capacity;
            return true;
        } else {
            return false;
        }
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (size > 0) {
            --size;
            ++front;
            front %= capacity;
            return true;
        } else {
            return false;
        }
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (size > 0) {
            return queue[front];
        } else {
            return -1;
        }
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (size > 0) {
            return queue[(rear - 1 + capacity) % capacity];
        } else {
            return -1;
        }
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return (size == 0);
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (size == capacity);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */