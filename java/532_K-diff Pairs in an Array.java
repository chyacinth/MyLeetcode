/**
 * 为避免重复，只考虑num + k在不在set里，而不考虑num - k的情况
 */
class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) { return 0; }
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.putIfAbsent(num, 0);
            mp.put(num, mp.get(num) + 1);
        }
        int result = 0;
        for (int num : mp.keySet()) {
            if (mp.containsKey(num + k)) { 
                if (k != 0 || (k == 0 && mp.get(num) > 1)) {
                    ++result; 
                }
            }
        }
        return result;
    }
}