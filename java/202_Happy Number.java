/**
 * 找规律题，没意思
 */
class Solution {
    public int sum(int n) {
        int result = 0;
        while (n > 0) {
            int tmp = n % 10;
            n = n / 10;
            result += tmp * tmp;
        }
        return result;
    }
    public boolean isHappy(int n) {
        int num = n;
        while (num != 1 && num != 4) {
            num = sum(num);
        }
        return (num == 1);
    }
}
