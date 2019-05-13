/**
 * nums记录所有的值
 * 哈希表<Integer, Set<Integer>> 记录值的出现位置。
 * 删除的时候随机选一个，然后用nums的最后一个代替他。
 */
class RandomizedCollection {

    private Map<Integer, Set<Integer>> valLocMp = new HashMap<>();
    private int n = 0;
    private ArrayList<Integer> nums = new ArrayList<>();
    private Random rand = new Random();
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean containsVal = valLocMp.containsKey(val) && valLocMp.get(val).size() > 0;
        nums.add(val);        
        valLocMp.putIfAbsent(val, new HashSet<>());
        valLocMp.get(val).add(nums.size() - 1);        
        return !containsVal;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {        
        Set<Integer> valLocs = valLocMp.get(val);
        if (valLocs != null && valLocs.size() > 0) {
            int lastElem = nums.get(nums.size() - 1);
            nums.remove(nums.size() - 1);
            Set<Integer> lastElemLocs = valLocMp.get(lastElem);
            lastElemLocs.remove(nums.size());
            if (val != lastElem) {
                int valLoc = valLocs.iterator().next();
                valLocs.remove(valLoc);
                nums.set(valLoc, lastElem);
                lastElemLocs.add(valLoc);
            }
            return true;
        }
        return false;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {        
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */