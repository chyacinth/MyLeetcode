/**
 * 基本思路就是看下一位加某个digit i 的时候，所有以i开头的数在总结果中的范围
 * 技巧：除了记录加某个digit i的范围，还要记录不加任何digit得到的数在总结果中的范围
 */
class Solution {
    private int getNum(String ns, String res, int j) {
        char ch = (char) (j + '0');
        if (res.isEmpty() && ch == '0') {
                return 0;
        }
        String result = res + ch;
        int retVal = 0;
        if (ns.startsWith(result)) {
            if (result.length() < ns.length()) {
                retVal += Integer.valueOf(ns.substring(result.length(), ns.length()));
            }
            retVal += 1;
            
            for (int i = 0; i < ns.length() - result.length(); ++i) {
                retVal += Math.pow(10, i);
            }
            return retVal;
        }
        if (result.compareTo(ns) < 0) {
            for (int i = 0; i <= ns.length() - result.length(); ++i) {
                retVal += Math.pow(10, i);
            }
            return retVal;
        }
        if (result.compareTo(ns) > 0) {
            for (int i = 0; i < ns.length() - result.length(); ++i) {
                retVal += Math.pow(10, i);
            }
            return retVal;
        }
        return retVal;
    }
    public int findKthNumber(int n, int k) {
        String result = "";
        String ns = String.valueOf(n);
        while (k > 0) {
            int[] numStartsWith = new int[11];
            for (int j = 0; j < 10; ++j) {
                numStartsWith[j + 1] = getNum(ns, result, j);
            }
            if (!result.isEmpty()) {
                numStartsWith[0] += 1;
            }
            for (int j = 1; j < 11; ++j) {
                numStartsWith[j] += numStartsWith[j-1];
            }
            int j = 0;
            while (j < 10 && numStartsWith[j] < k) {
                ++j;
            }
            if (j - 1 >= 0) {
                k -= numStartsWith[j - 1];
            } else {
                break;
            }
            result += (j - 1);
        }
        return Integer.valueOf(result.toString());
    }
}