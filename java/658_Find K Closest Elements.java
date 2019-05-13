/**
 * 简单record
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {        
        //num = idx - 10000
        //idx = num + 10000
        int[] record = new int[20002];
        for (int num : arr) {
            ++record[num + 10000];
        }
        LinkedList<Integer> result = new LinkedList<>();
        final int n = record.length;
        int i = x + 10000;
        int l = i - 1;
        int r = i + 1;
        while (k > 0 && record[i] > 0) {
            --k;
            --record[i];
            result.add(i - 10000);
        }
        while ((k > 0) && (l >= 0 || r < n)) {            
            if (l >= 0 && record[l] > 0) {
                while (k > 0 && record[l] > 0) {
                    --k;
                    --record[l];
                    result.addFirst(l - 10000);
                }                
            }
            --l;
            if (r < n && record[r] > 0) {
                while (k > 0 && record[r] > 0) {
                    --k;
                    --record[r];
                    result.addLast(r - 10000);
                }                
            }
            ++r;
        }
        return result;
    }
}