/**
 * Before designing the algorithm, you' ll need to specify 
 * which operation(add, find) will be the most frequent part.
 * Because we can have either add or find to be O(N) and the other to
 * be O(1)
 */
class TwoSum {
  /** Initialize your data structure here. */
  private List<Integer> nums;
  private Map<Integer, Integer> occurMap;
  
  public TwoSum() {
    nums = new ArrayList<>();
    occurMap = new HashMap<>();
  }
    
  /** Add the number to an internal data structure.. */
  public void add(int number) {        
    nums.add(number);
    occurMap.put(number, occurMap.getOrDefault(number, 0) + 1);
  }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
      for (int num : nums) {
        if (occurMap.get(value - num) != null && 
            (value - num != num || occurMap.get(num) > 1)) {
          return true;
        }
      }
      return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */