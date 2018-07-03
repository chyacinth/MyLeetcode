/**
 * ……不知出题意义何在？
 */
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        int n = bits.length;
        while (i < n) {
            if (i == n - 1) return true;
            if (bits[i] == 1) {
                i += 2;
            }
            else {
                i += 1;
            }
        }
        return false;
    }
}