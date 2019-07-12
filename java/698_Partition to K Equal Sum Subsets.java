class Solution {
    
    private boolean dfs(int id, int[] nums, List<List<Integer>> subsets, 
                        List<Integer> sumOfSubsets, int subSum) {
        if (id >= nums.length) {
            for (int i = 0; i < subsets.size(); ++i) {
                List<Integer> subset = subsets.get(i);
                int sum = sumOfSubsets.get(i);
                if (sum != subSum) {
                    return false;
                }
            }
            return true;
        }
        boolean retVal = false;
        Set<Integer> visitedSum = new HashSet<>();
        for (int i = 0; i < subsets.size(); ++i) {
            List<Integer> subset = subsets.get(i);
            int sum = sumOfSubsets.get(i);
            if (!visitedSum.contains(sum) && sum + nums[id] <= subSum) {
                visitedSum.add(sum);
                subset.add(id);
                sumOfSubsets.set(i, sum + nums[id]);
                retVal |= dfs(id + 1, nums, subsets, sumOfSubsets, subSum);
                if (retVal) { return true; }
                sumOfSubsets.set(i, sum);
                subset.remove(subset.size() - 1);
            }
        }
        return retVal;
    }
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) { return false; }
        int subSum = sum / k;
        List<List<Integer>> subsets = new ArrayList<>(k);
        for (int i = 0; i < k; ++i) {
            subsets.add(new ArrayList<>());
        }
        List<Integer> sumOfSubsets = new ArrayList<>(k);
        for (int i = 0; i < k; ++i) {
            sumOfSubsets.add(0);
        }
        return dfs(0, nums, subsets, sumOfSubsets, subSum);
    }
}