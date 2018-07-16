/**
 * Hash记录 数字->出现次数，然后反过来一个Hash<Int,List>记录出现次数->数字，然后从大到小遍历
 * Hash，在找到k个之前不停地添加找到的元素
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {        
        HashMap<Integer, Integer> map = new HashMap<>();        
        for (int i = 0; i < nums.length; ++i) {
            Integer cnt = map.get(nums[i]);
            if (cnt == null) {
                cnt = 1;
                map.put(nums[i], cnt);
            } else {
                ++cnt;
                map.put(nums[i], cnt);
            }            
        }
        HashMap<Integer, List<Integer>> mapOccur2Num = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int occur = entry.getValue();
            int num = entry.getKey();
            List<Integer> value = mapOccur2Num.get(occur);
            if (value == null) {
                value = new ArrayList<>();
                value.add(num);
                mapOccur2Num.put(occur, value);
            } else {
                value.add(num);
                mapOccur2Num.put(occur, value);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length; i >= 1; --i) {
            if (k <= 0) break;
            List<Integer> value = mapOccur2Num.get(i);            
            if (value != null) {
                for (Integer j : value) {
                    result.add(j);
                    k -= 1;
                    if (k <= 0) break;    
                }                
            }
        }
        return result;
    }
}