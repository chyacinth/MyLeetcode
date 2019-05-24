/**
 * 难题，见https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2471/Very-concise-O(log(min(MN)))-iterative-solution-with-detailed-explanation
 */
// 2n + 1
// n + m + 1
// #1#2#3#4#
// 012345678
//lx00112233
//r001122334
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0;
        int high = nums2.length * 2;
        while (low <= high) {
            int k2 = (low + high) / 2;
            int k1 = nums1.length + nums2.length - k2;
            double l1 = k1 == 0? Integer.MIN_VALUE : nums1[(k1-1)/2];
            double l2 = k2 == 0? Integer.MIN_VALUE : nums2[(k2-1)/2];
            double r1 = k1/2 < nums1.length? nums1[(k1)/2] : Integer.MAX_VALUE;
            double r2 = k2/2 < nums2.length? nums2[(k2)/2] : Integer.MAX_VALUE;            
            
            if (l1 > r2) {
                low = k2 + 1;
            } else if (l2 > r1) {
                high = k2 - 1;
            } else {
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
            }
        }
        return -1;
    }
}