class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        Map<Integer, Integer> occurByElemMin = new HashMap<>();
        Map<Integer, Integer> occurByElemMax = new HashMap<>();
        int min = -1;
        int max = -1;
        int result = 0;

        for (int i = 0; i < A.length; ++i) {
            while (occurByElemMin.size() < K && min + 1< A.length) {
                min += 1;
                occurByElemMin.put(A[min], occurByElemMin.getOrDefault(A[min], 0) + 1);
                if (min > max) {
                    occurByElemMax.put(A[min], occurByElemMax.getOrDefault(A[min], 0) + 1);
                }
            }
            if (max < min) { max = min; }            
            
            while (occurByElemMax.size() == K && max + 1< A.length) {
                max += 1;
                occurByElemMax.put(A[max], occurByElemMax.getOrDefault(A[max], 0) + 1);
            }
            
            if (occurByElemMax.size() > K) {
                occurByElemMax.put(A[max], occurByElemMax.get(A[max]) - 1);
                if (occurByElemMax.get(A[max]) == 0) {
                    occurByElemMax.remove(A[max]);
                }
                --max;
            }
            
            //System.out.println(occurByElemMin.size() + " " + occurByElemMax.size());
            
            if (occurByElemMin.size() >= K) {
                result += max - min + 1;
            }
            occurByElemMin.put(A[i], occurByElemMin.getOrDefault(A[i], 0) - 1);
            occurByElemMax.put(A[i], occurByElemMax.getOrDefault(A[i], 0) - 1);
            
            if (occurByElemMin.get(A[i]) == 0) {
                occurByElemMin.remove(A[i]);
            }
            if (occurByElemMax.get(A[i]) == 0) {
                occurByElemMax.remove(A[i]);
            }
        }
        return result;
    }    
}