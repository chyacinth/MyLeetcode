/*
可以只调用一次递归函数搞定，不用进行n次递归函数调用，在递归函数中把中间结果记下来即可
*/
class Solution {
    List<List<Integer>> results = new ArrayList<>();
    public void findComb(int st, int[] nums, int k, List<Integer> result) {
        results.add(result);
        if (k == 0) {            
            return;
        }
        for (int i = st; i < nums.length; i++) {
            result.add(nums[i]);
            findComb(i + 1, nums, k - 1, new ArrayList<Integer>(result));
            result.remove(result.size() - 1);
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {        
        List<Integer> result = new ArrayList<>();
        findComb(0, nums, nums.length, result);
        return results;
    }
}