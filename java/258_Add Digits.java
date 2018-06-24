/**
 * 找规律，如果要证明的话可以考虑数学归纳法？
 */
class Solution {
    public int addDigits(int num) {
        return ((num - 1) % 9) + 1;
    }
}