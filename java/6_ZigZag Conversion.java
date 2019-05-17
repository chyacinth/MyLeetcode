/**
 * 简单数学推导
 */
class Solution {
    public String convert(String s, int numRows) {
        int m = s.length();
        int cnt = 0;
        if (m == 0 || numRows <= 1) { return s; }
        StringBuilder resultSb = new StringBuilder();        
        for (int i = 0; i < numRows; ++i) {
            int col = 0;
            while (col - i < m) {
                int l = col - i;
                int r = col + i;
                if (l >= 0) { resultSb.append(s.charAt(l)); }
                if (r != l && r < m && i != numRows - 1) { resultSb.append(s.charAt(r)); }
                col += (2 * numRows - 2);
            }
        }
        return resultSb.toString();
    }
}
/**Start
    0       2k-2        // n * (2k - 2)
    1      2k               n * (2k-2)  -1/+1
    2    ..
    3   k+1
    .. k
    k-1
   **/     
    