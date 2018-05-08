/*
binary search
pay attention to corner case
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) return false;
        int m = matrix[0].length;
        if (m == 0) return false;
        int mid = 0, l = 0, r = n - 1;
        int idx = -1, idy = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (matrix[mid][0] < target) {
                if (idx < mid) {idx = mid;}
                l = mid + 1;
            }
            else if (matrix[mid][0] > target) {
                r = mid - 1;
            }
            else return true;
        }
        if (idx == -1) return false;
        l = 0; r = m - 1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (matrix[idx][mid] < target) {
                l = mid + 1;                
            } else if (matrix[idx][mid] > target) {
                r = mid - 1;
            }
            else {return true;}            
        }
        return false;
    }
}