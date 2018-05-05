class Solution {
    public int[] plusOne(int[] digits) {
        boolean allNine = false;
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i >= 0; i--) {            
            if (digits[i] > 9) {
                if (i > 0) {digits[i - 1] += digits[i] / 10;}
                else allNine = true;
                digits[i] = digits[i] % 10;
            }
        }
        if (allNine) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++) {result[i] = 0;}
            return result;
        }
        return digits;
    }
}