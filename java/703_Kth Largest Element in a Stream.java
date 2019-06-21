class KthLargest {

    private Queue<Integer> kLargestNums = new PriorityQueue<>();
    private int k = 0;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            if (kLargestNums.size() < k) { kLargestNums.offer(num); }
            else if (num > kLargestNums.peek()) {
                kLargestNums.poll();
                kLargestNums.offer(num);
            }
        }
    }
    
    public int add(int val) {
        if (kLargestNums.size() < k) { kLargestNums.offer(val); }
        else if (val > kLargestNums.peek()) {
            kLargestNums.poll();
            kLargestNums.offer(val);
        }
        return kLargestNums.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */