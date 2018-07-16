/**
 * 两个Set完事
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {        
        HashMap<Integer, Boolean> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            map.put(num, true);
        }
        for (int num : nums2) {
            Boolean exist = map.get(num);            
            if (exist != null && exist == true) {
                set.add(num);
            }
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (int num : set) {            
            result[i] = num;
            ++i;                
        }
        return result;
    }
}