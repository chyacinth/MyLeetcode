/**
 * 难题。经典逆序对解法（归并排序）
 */
class Solution {
    private long result = 0;
    
    public void merge(int[] a, int[] l, int[] r) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < l.length && j < r.length) {
            if (l[i] < r[j]) {
                a[k++] = l[i++];
            } else {                
                a[k++] = r[j++]; 
            }
        }
        while (i < l.length) {
            a[k++] = l[i++];
        }
        while (j < r.length) {
            a[k++] = r[j++];
        }
    }
    public void mergeSort(int[] a) {
        int n = a.length;
        if (n <= 1) return;
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        for (int i = 0; i < mid; ++i) l[i] = a[i];
        for (int i = mid; i < n; ++i) r[i - mid] = a[i];
        mergeSort(l);
        mergeSort(r);
        for (int i = 0; i < r.length; ++i) {
            int low = 0;
            int high = l.length - 1;
            int first = 0;
            while (low <= high) {
                int midd = low + (high - low) / 2;
                if ((long) l[midd] > (long) r[i] * 2) {
                    first = midd;
                    high = midd - 1;
                } else {
                    low = midd + 1;
                }
            }
            //System.out.println(l[first] + " " + r[i]);
            if ((long) l[first] > (long) r[i] * 2) {
                result += l.length - first;
            }
        }        
        merge(a, l, r);
    }
    public int reversePairs(int[] nums) {
        mergeSort(nums);
        return (int) result;        
    }
}