/*
数学题
问题的一步步归约过程如下：
->找1~N中的满足条件：因数个数为奇数 的数的个数
->找1~N中的满足条件：质因数分解后每个质因数的次数为偶数 的数的个数
->找1~N中的满足条件：完全平方数 的数的个数
->(int)sqrt(N)

*/
class Solution {
    public int bulbSwitch(int n) {
        return ((int)Math.sqrt(n));
    }
}