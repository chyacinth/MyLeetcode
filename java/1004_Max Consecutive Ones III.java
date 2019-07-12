class Solution {
    public int longestOnes(int[] A, int K) {
        List<Integer> locsOfZeros = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < A.length; ++i) {
            int num = A[i];
            if (num == 0) {
                locsOfZeros.add(i);
            }
            int farthestZeroLoc = locsOfZeros.size() - K - 1;
            if (farthestZeroLoc < 0) {
                farthestZeroLoc = -1;
            } else {
                farthestZeroLoc = locsOfZeros.get(farthestZeroLoc);
            }
            
            result = Math.max(
                result, 
                i - farthestZeroLoc
            );
        }
        return result;
    }
}