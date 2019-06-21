class Solution {
    public int[] sortedSquares(int[] A) {
        int l = 0;
        int r = A.length - 1;
        int i = A.length - 1;
        int[] result = new int[A.length];
        while (l <= r) {
            if (Math.abs(A[l]) >= Math.abs(A[r])) {
                result[i--] = A[l] * A[l];
                ++l;
            } else {
                result[i--] = A[r] * A[r];
                --r;
            }
        }
        return result;
    }
}