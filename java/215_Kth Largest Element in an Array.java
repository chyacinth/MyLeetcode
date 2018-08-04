class Solution {
    public int partition(int[] nums, int l, int r, int k) {
        int left = l;
        int right = r;
        int key = nums[left];
        while (left < right) {
            //find 1st num larger key from right
            while (left < right && nums[right] <= key) { --right; }
            nums[left] = nums[right];
            //find 1st num smaller key from left
            while (left < right && nums[left] >= key) { ++left; }
            nums[right] = nums[left];
        }
        nums[left] = key;
        int leftNum = left - l + 1;
        if (leftNum < k) { 
            return partition(nums, left + 1, r, k - leftNum); 
        } else if (leftNum > k) {
            return partition(nums, l, left - 1, k); 
        } else {
            return key;
        }
    }
    public int findKthLargest(int[] nums, int k) {
        return partition(nums, 0, nums.length - 1, k);
    }
}