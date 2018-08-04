/**
 * 第一层： 1 2 3 4 5 6 7
 * 第二层： 2 4 6
 * ...
 * 用O(logN)得到每i层的数字数
 * 如果是想将第i+1层用1,2,3...表达转换到第i层，则：
 * 1. 若第i层删掉的数是偶数index，则转换方式为 *2-1
 * 2. 若第i层删掉的数是奇数index，则转换方式为 *2
 * 第i层删掉的数是偶数<=>第i层有偶数个数
 * 搞定
 */
class Solution {
    public int lastRemaining(int n) {        
        int result = 1;        
        int rounds = (int) (Math.log(n) / Math.log(2));             
        int divisor = (int) Math.pow(2, rounds - 1);
        for (int i = 0; i < rounds; ++i) {
            int num = n / divisor;
            int level = rounds - i;
            divisor /= 2;            
            if (level % 2 == 1) {
                result *= 2;
            } else {
                if (num % 2 == 0) {
                    result *= 2;
                    result -= 1;                    
                } else {
                    result *= 2;
                }
            }            
        }
        return result;
    }
}