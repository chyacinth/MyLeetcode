/**
 * 遍历，维护开始和结束
 */
class Solution {
    public List<String> summaryRanges(int[] nums) {        
        int i = 1, st = 0, ed = 0;
        List<String> results = new ArrayList<>();
        if (nums.length == 0) return results;
        while (i < nums.length) {
            if (nums[i] - 1 == nums[i - 1]) ed += 1;
            else {                
                results.add(st == ed? String.valueOf(st):(st+"->"+ed));
                st = nums[i];
                ed = nums[i];
            }
            i+=1;
        }
        results.add(st == ed? String.valueOf(st):(st+"->"+ed));
        return results;
    }
}