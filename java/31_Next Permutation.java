/**
 * 简单
 */
class Solution {
  public void nextPermutation(int[] nums) {
    int n = nums.length;
    // find first i < i + 1
    int i = n - 2;
    while (i >= 0) {
      if (nums[i] < nums[i + 1]) { break; }
      --i;
    }
    // swap i with min > i
    if (i >= 0) {
      int k = 0;
      for (int j = i + 1; j < n; ++j) {
        if (nums[j] > nums[i]) {
          k = j;
        } else {
          break;
        }
      }
      int temp = nums[i];
      nums[i] = nums[k];
      nums[k] = temp;
    }
    // reorder from i + 1
    int l = i + 1;
    int r = n - 1;
    while (l < r) {
      int temp = nums[l];
      nums[l] = nums[r];
      nums[r] = temp;
      ++l;
      --r;
    }
  }
}