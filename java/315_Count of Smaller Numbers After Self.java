/**
 * Divide and Conquer
 * based on the thought behind merge sort, we can count the 
 * number of reverse pair.
 * Then we just need to go one step further. During the 
 * merge process, instead of computing the total number 
 * of revesrse pair, we add the number to an array that record the count
 * of smaller numbers after each element sepearately.
 * the reverse 
 */
class Solution {
    public List<Integer> countSmaller(int[] nums) {   
        List<Integer> result = new ArrayList<>();        
        int[] order = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            result.add(0);
            order[i] = i;
        }
        mergeSort(nums, order, result);
        return result;
    }
    public void mergeSort(int[] nums, int[] order, List<Integer> result) {
        if (nums.length <= 1) { return; }
        int[] L = new int[nums.length / 2];
        int[] lOrder = new int[nums.length / 2];
        int[] R = new int[nums.length - nums.length / 2];
        int[] rOrder = new int[nums.length - nums.length / 2];
        
        for (int i = 0; i < nums.length / 2; ++i) {
            L[i] = nums[i];
            lOrder[i] = order[i];
        }
        for (int i = nums.length / 2; i < nums.length; ++i) {
            R[i - nums.length / 2] = nums[i];
            rOrder[i - nums.length / 2] = order[i];
        }
        mergeSort(L, lOrder, result);
        mergeSort(R, rOrder, result);
        int l = 0;
        int r = 0;
        int cnt = 0;
        while (l < L.length || r < R.length) {
            if (r == R.length || (l < L.length && r < R.length && L[l] > R[r])) {
                nums[cnt] = L[l];
                order[cnt] = lOrder[l];
                result.set(lOrder[l], result.get(lOrder[l]) + R.length - r);
                ++cnt;
                ++l;
            } else if (l == L.length || (l < L.length && r < R.length && L[l] <= R[r])) {
                nums[cnt] = R[r];
                order[cnt] = rOrder[r];
                ++cnt;
                ++r;
            }
        }
    }
}