/**
 * 注意证明算法一定会结束
 */
class Solution {
    public int sum(int a, int b) {
        int ta, tb;
        while ((a & b) != 0) {
            ta = a ^ b;
            tb = (a & b) << 1;
            a = ta;
            b = tb;
        }                
        return a | b;
    }
    public int getSum(int a, int b) {                
        return sum(a,b);
    }
}