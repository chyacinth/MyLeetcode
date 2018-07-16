/**
 * ?
 */
class Solution {
    boolean isSelfDividing(int n) {
        int tmpN = n;
        while (tmpN > 0) {
            int tmpDivisor = tmpN % 10;            
            if (tmpDivisor == 0 || n % tmpDivisor != 0) { return false; } 
            tmpN = tmpN / 10;
        }
        return true;
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> results = new ArrayList<>();
        for (int i = left; i <= right; ++i) {
            if (isSelfDividing(i)) results.add(i);
        }
        return results;
    }
}