/*
leetcode 81: 重复数字会导致什么情况？
nums[l] = nums[mid] = nums[r]，此时无法判断target在哪里，需要l++，直到nums[l]!=nums[r]为止，才可以判断
*/
class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid, midVal;
        while (l <= r) {
            while (nums[l] == nums[r] && l < r) {l++;}
            mid = (l + r) / 2;
            midVal = nums[mid];
            if (midVal == target) {return true;}
            if (midVal <= nums[r]) {                
                if (midVal <= target && target <= nums[r]) {
                    l = mid + 1;
                }
                else r = mid - 1;                
            }
            else {
                if (nums[l] <= target && target <= midVal) {
                    r = mid - 1;
                }
                else l = mid + 1;
            }            
        }
        return false;
    }
}