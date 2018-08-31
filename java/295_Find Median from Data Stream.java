/**
 * Use two heap to record the max val of first half and 
 * the min val of the second half. Keep the size of second half
 * always equal to the size of first half or add one.
 */
class MedianFinder {
  private Queue<Long> small = new PriorityQueue<>(11, (a,b) -> {return b.compareTo(a);});
  private Queue<Long> large = new PriorityQueue<>();
  /** initialize your data structure here. */
  public MedianFinder() {    
  }
    
  public void addNum(int num) {    
    if (small.size() >= large.size()) {
      if (large.isEmpty() || (long)num >= small.peek()) { 
        large.offer((long)num); 
      } else {
        large.offer(small.poll());
        small.offer((long)num);
      }
    } else {      
      if ((long)num <= large.peek()) {
        small.offer((long)num);
      } else {
        Long t = large.poll();
        small.offer(t);
        large.offer((long)num);
      }
    }
  }
    
  public double findMedian() {
      if (small.size() >= large.size()) {
        return ((double)small.peek() + large.peek()) / 2;
      } else {        
        return (double)large.peek();
      }
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */