/*
倒过来合并！为什么会没想到？脑残了
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, choose;
        for (int i = (n + m - 1); i >= 0; i--) {
            if (p2 < 0 || (p1 >= 0 && nums1[p1] > nums2[p2])) {choose = 1;}
            else {choose = 2;}
            if (choose == 1) {
                nums1[i] = nums1[p1];
                p1--;
            }
            else {
                nums1[i] = nums2[p2];
                p2--;
            }
        }
    }
}