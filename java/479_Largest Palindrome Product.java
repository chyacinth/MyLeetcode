/**
 * 暴力
 * 注意类型转换，以及——
 * str.reverse() ←这个函数会把str自己也翻转啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
 */
class Solution {
    long getPalindrome(String s) {
        StringBuffer str = new StringBuffer(s);        
        return Long.valueOf(str.append(new StringBuilder(str).reverse()).toString());
    }
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        int max = (int) Math.pow(10,n)-1;
        for (int i = max; i > 0; --i) {
            long val = getPalindrome(String.valueOf(i));
            for (int j = max; j > max / 10; --j) {
                if ((int)(val / j) > max) { break; }
                if (val % j == 0) {                                        
                    return (int) (val % 1337);
                }
            }
        }
        return 0;
    }
}