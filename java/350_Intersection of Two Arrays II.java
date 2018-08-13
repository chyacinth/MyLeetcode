/**
 * 不难，但是有深入的follow up，见：
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/82281/Two-C++-solutions:-hashtable-and-sort+binary-search.-Time-and-space-complexity-analyzed.
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int num : nums1) map.put(num, map.getOrDefault(num, 0) + 1);
        for (int num : nums2) {
            if (map.containsKey(num)) {
                int occur = map.get(num);
                if (occur > 0) {
                    result.add(num);
                    --occur;
                    map.put(num, occur);
                }
            }
        }
        int[] r = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return r;
    }
}