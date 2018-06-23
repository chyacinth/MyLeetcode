/**
 * 即求x ^ y中1的个数
 * 求一个数二进制的1的个数：
 * 1. 快速方法：x = x & (x - 1)可以消去x最右边的1，不停做这个运算，每次计数器加一，直到x为0
 * 2. 简单方法：移位，看到一就加一
 * 
 */
class Solution {
    public int hammingDistance(int x, int y) {
        x ^= y;
        int cnt;
        for (cnt = 0; x > 0; cnt++) {
            x &= (x - 1);
        }
        return cnt;
    }
}