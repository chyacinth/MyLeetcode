/**
 * 居然没想到！！ 可以用最接近maxInt的那个三的次幂，成为maxThreePower，
 * 然后判断maxThreePower % n是否为0，因为maxThreePower的因数全为0，所以只有n的因数全为0才余数为0
 * 当然用log应该也行，不过log本身应该不是O(N)
 */
class Solution {
    public boolean isPowerOfThree(int n) {
        long threeMaxInt = 1162261467;
        return (n > 0) && (threeMaxInt % n == 0);
    }
}