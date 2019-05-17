/**
 * x最大和y最大可以分开考虑。简单数学题
 */
class Solution {
    public int minTotalDistance(int[][] grid) {
        int n = grid.length;
        if (n == 0) { return 0; }        
        int m = grid[0].length;
        if (m == 0) { return 0; }
        List<Integer> rowVals = new ArrayList<>();
        List<Integer> colVals = new ArrayList<>();
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    rowVals.add(i);
                }
            }
        }
        
        for (int j = 0; j < m; ++j) {
            for (int i = 0; i < n; ++i) {
                if (grid[i][j] == 1) {
                    colVals.add(j);
                }
            }
        }
        
        int l = 0;
        int r = rowVals.size() - 1;
        int result = 0;
        while (l < r) {
            result += rowVals.get(r) - rowVals.get(l);
            ++l;
            --r;
        }
        l = 0;
        r = colVals.size() - 1;
        while (l < r) {
            result += colVals.get(r) - colVals.get(l);
            ++l;
            --r;
        }
        return result;
    }
}