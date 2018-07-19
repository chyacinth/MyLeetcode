/**
 * 二分
 * 找中间的元素，如果它不是要找的元素，设第二个这个元素在位置i，则若0~i有奇数个元素，说明在i左边。否则在i右边
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;   
        if (r < 0) return 0;
        if (r == 0) return nums[0];        
        int mid = 0;
        while (l <= r) {            
            mid = (l + r) / 2;            
            if (l == r) { return nums[mid]; }
            if (mid + 1 < nums.length && nums[mid + 1] == nums[mid]) { ++mid; }
            if ((mid + 1) % 2 == 1) { r = mid - 1; }
            else { l = mid + 1; }
        }
        return nums[mid];
    }
}