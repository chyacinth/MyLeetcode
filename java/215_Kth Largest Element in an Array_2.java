class Solution {
  
  private int helper(int[] nums, int left, int right, int k) {
    int key = nums[left];
    int l = left;
    int r = right;
    while (left < right) {
      while (left < right && nums[right] <= key) --right;
      nums[left] = nums[right];
      while (left < right && nums[left] >= key) ++left;
      nums[right] = nums[left];
    }
    nums[left] = key;
    if (left - l + 1 == k) { return nums[left]; }
    else if (left - l + 1 < k) {
      return helper(nums, left + 1, r, k - (left - l + 1));
    } else if (left - l + 1 > k) {
      return helper(nums, l, left - 1, k);
    }
    return 0;
  }
  
  public int findKthLargest(int[] nums, int k) {
    return helper(nums, 0, nums.length - 1, k);
  }
}