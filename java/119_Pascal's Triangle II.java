/**
 * 为了节省空间，前一层的状态已经记录在数组中了，只是为了在计算当次状态时如果正序计算会覆盖掉，因此需要倒序计算
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] a = new Integer[rowIndex + 1];        
        a[0] = 1;
        for (int i = 0; i < rowIndex; i++) {
            a[i + 1] = a[i];
            for (int j = i; j > 0; --j) {                
                a[j] = a[j - 1] + a[j];
            }            
        }
        return Arrays.asList(a);
    }
}