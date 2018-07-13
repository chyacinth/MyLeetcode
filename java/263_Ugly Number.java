/**
 * 不停除就完事了
 */
class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        while (true) {
            if (num == 1) return true;
            if (num % 2 == 0) {
                num /= 2;
                continue;
            }
            if (num % 3 == 0) {
                num /= 3;
                continue;
            }
            if (num % 5 == 0) {
                num /= 5;
                continue;
            }
            break;
        }
        return false;
    }
}