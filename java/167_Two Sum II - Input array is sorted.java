/**
 * two pointer
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int[] result = new int[2];
        int sum = 0;
        while (l < r) {
            sum = numbers[l] + numbers[r];
            if (sum < target) l += 1;
            else if (sum > target) r -= 1;
            else {
                result[0] = l + 1;
                result[1] = r + 1;
                return result;
            }
        }
        return result;
    }
}