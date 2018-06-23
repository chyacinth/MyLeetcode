/*
数学题：倒推：如果要让对手剩一个，上一次必须是4，。。。
*/
class Solution {
    public boolean canWinNim(int n) {
        return (n % 4 != 0);
    }
}