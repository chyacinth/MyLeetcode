/**
 * 设最大的数为p1,p2,p3，最小数为n1,n2，则根据p1~p3,n1~n2的正负性讨论得到，result = max (p1*p2*p3, p1*n1*n2)
 */
class Solution {
    public int find(int[] a, int left, int right, int kth)
    {
        int key = a[left];
        int l = left;
        int r = right;
        while(left < right){
            while(left < right && a[right] >= key) right--;     //从右找到第一个比key小的
            a[left] = a[right];
            while(left < right && a[left] <= key) left++;       //从左找到第一个比key大的
            a[right] = a[left];   
        }        
        a[left] = key;    
        if (left - l == kth) return a[left];
        else {
            if (left - l < kth) return find(a, left + 1, r, kth - left + l - 1);
            else return find(a, l, left - 1, kth);
        }
    }
    public int maximumProduct(int[] nums) {
        int r = nums.length - 1;
        int p1 = find(nums, 0, r, r);
        int p2 = find(nums, 0, r, r - 1);
        int p3 = find(nums, 0, r, r - 2);
        int n1 = find(nums, 0, r, 0);
        int n2 = find(nums, 0, r, 1);
        int result = nums[0] * nums[1] * nums[2];
        if (result < p1 * p2 * p3) { result = p1 * p2 * p3; }        
        if (result < p1 * n1 * n2) { result = p1 * n1 * n2; }        
        return result;        
    }
}