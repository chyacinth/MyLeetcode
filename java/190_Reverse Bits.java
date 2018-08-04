/**
 * java 的无符号右移是>>>
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; ++i) {
            int temp = n;
            temp = temp >>> i;
            temp = temp << 31;
            temp = temp >>> i;
            result |= temp;
        }
        return result;
    }
}