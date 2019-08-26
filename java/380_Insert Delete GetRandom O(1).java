/**
 * 如果要随机，那只能是用0..n对应数字的方法。但这样删除数字的时候怎么办？简单，只要用最后一个n对应的数字覆盖掉就行了
 */

class RandomizedSet {

  private Map<Integer, Integer> idToNum = new HashMap<>();
  private Map<Integer, Integer> numToId = new HashMap<>();
  Random random = new Random();
  int n = 0;
  
  /** Initialize your data structure here. */
  public RandomizedSet() {
  }
    
  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if (!numToId.containsKey(val)) {
      idToNum.put(n, val);
      numToId.put(val, n);
      ++n;
      return true;
    } else {
      return false;
    }
  }
    
  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if (numToId.containsKey(val)) {
      int m = numToId.get(val);
      numToId.remove(val);
      idToNum.remove(m);
      if (m < n - 1) {
        idToNum.put(m, idToNum.get(n - 1));
        numToId.put(idToNum.get(n - 1), m);
        idToNum.remove(n - 1);
      }
      --n;
      return true;
    } else {
      return false;
    }
  }
    
  /** Get a random element from the set. */
  public int getRandom() {
    int randId = random.nextInt(n);
    return idToNum.get(randId);
  }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */