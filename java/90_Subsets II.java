class Solution {
    List<List<Integer>> results = new ArrayList<>();
    public void dfs(int[] nums, int st, List<Integer> result) {
        results.add(new ArrayList<Integer>(result));
        for (int i = st; i < nums.length; i++) {
            if (i == st || nums[i] != nums[i - 1]) {                                                
                result.add(nums[i]);
                dfs(nums, i + 1, result);
                result.remove(result.size() - 1);
            }
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>());
        return results;
    }
}