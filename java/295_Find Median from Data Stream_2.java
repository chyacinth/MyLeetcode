class MedianFinder {
  
  private Queue<Integer> low = 
    new PriorityQueue<>(Collections.reverseOrder());
  private Queue<Integer> high = new PriorityQueue<>();
  int n = 0;

  /** initialize your data structure here. */
  public MedianFinder() {
    
  }
    
  public void addNum(int num) {
    if (low.size() == 0 || num <= low.peek()) {
      low.offer(num);
    } else {
      high.offer(num);
    }
    if (low.size() >= high.size() + 2) {
      int mid = low.poll();
      high.offer(mid);
    } else if (low.size() + 2 <= high.size()) {
      int mid = high.poll();
      low.offer(mid);
    }
    ++n;
  }

  public double findMedian() {
    if (n % 2 == 0) {
      return ((double) (low.peek() + high.peek())) / 2;
    } else {
      if (low.size() > high.size()) {
        return low.peek();
      } else {
        return high.peek();
      }
    }
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */