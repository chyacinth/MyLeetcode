/**
 * 1~n中5作为因数的个数
 * 5出现作为因数一次的数：5*(1,2,3...)
 * 5出现作为因数两次的数：5*5*(1,2,3...)
 * ...
 */
class Solution {
    public int trailingZeroes(int n) {
        int result = 0;
        while (n > 0) {
            n = n / 5;
            result += n;
        }
        return result;
    }
}