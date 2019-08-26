/**
 * 难题，需要二分
 */
class Solution {
  public int splitArray(int[] nums, int m) {
    long l = 0;
    long r = 0;
    for (int i = 0; i < nums.length; ++i) {
      l = Math.max(nums[i], l);
      r += nums[i];
    }
    long result = r;
    while (l <= r) {
      long mid = (l + r) / 2;
      long sum = 0;
      int split = 0;
      for (int i = 0; i < nums.length; ++i) {
        if (sum + nums[i] <= mid) {
          sum += nums[i];
        } else {
          split += 1;
          sum = nums[i];
        }
      }
      split += 1;
      if (split <= m) {
        r = mid - 1;
        result = Math.min(result, mid);
      } else {
        l = mid + 1;
      }
    }
    return (int) result;
  }
}