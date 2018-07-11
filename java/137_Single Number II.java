/**
 * 两种办法：
 * 其实就是三进制的无符号加法(non-carry addition)。使用二进制做三进制无符号加法
 * 加法的结果用三进制存储
 * 1. 简单方法，遍历32次，每次计算结果2进制位的第i bit。计算方法为数组中所有数的i比特加起来模三，这样可以消去出现三次的数
 * 2. 用三个变量，分别记录和中哪些位是2，哪些位是1，哪些位是0。
 */
class Solution {
    public int singleNumber(int[] nums) {
        int zero = 0xffffffff;
        int one = 0;
        int two = 0;        
        int tmp = two;
        for (int i = 0; i < nums.length; ++i) {
            tmp = two;
            two = (two & ~nums[i]) | (one & nums[i]);
            one = (one & ~nums[i]) | (zero & nums[i]);
            zero = (zero & ~nums[i]) | (tmp & nums[i]);
        }
        return (one + 2 * two);
    }
}