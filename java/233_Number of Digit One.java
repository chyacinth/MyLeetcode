//独自计算每一位的1的出现次数
class Solution {
    public int countDigitOne(int n) {
        int dig = 0, temp = n, result = 0, cnt = 1, last = 0;
        while (temp > 0) {
            temp /= 10;
            dig += 1;
        }
        temp = n;
        for (int i = 0; i < dig; i++) {
            last = temp % 10;
            temp = temp / 10;            
            
            if (last > 1) {
                result += (temp + 1)* cnt;
            }
            else if (last == 1) {
                result += temp * cnt + (n % cnt + 1);
            }
            else {
                result += (temp)* cnt;
            }
            cnt *= 10;
        }
        return result;
    }
}