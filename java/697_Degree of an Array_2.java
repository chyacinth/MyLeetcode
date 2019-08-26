class Solution {
  public int findShortestSubArray(int[] nums) {
    int maxDegree = 0;
    int result = nums.length;
    Map<Integer, Integer> numToStart = new HashMap<>();
    Map<Integer, Integer> numToDegree = new HashMap<>();
    Set<Integer> qualifiedNums = new HashSet<>();
    for (int i = 0; i < nums.length; ++i) {
      numToStart.putIfAbsent(nums[i], i);
      numToDegree.put(nums[i], numToDegree.getOrDefault(nums[i], 0) + 1);
      if (maxDegree == numToDegree.get(nums[i])) {
        if (i - numToStart.get(nums[i]) + 1 < result) {
          result = i - numToStart.get(nums[i]) + 1;
        }
      } else if (maxDegree < numToDegree.get(nums[i])) {
        result = i - numToStart.get(nums[i]) + 1;
        maxDegree = numToDegree.get(nums[i]);
      }
    }
    return result;
  }
}