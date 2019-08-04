class Solution {
    private void swap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
    
    private int toNum(int[] d) {
        int res = 0;
        for (int i = 0; i < d.length; ++i) {
            res = res * 10 + d[i];
        }
        return res;
    }
    
    public int maximumSwap(int num) {
        int[] digits = new int[(int) (Math.log10(num) + 1)];
        int k = digits.length - 1;
        int result = num;
        while (num > 0) {
            digits[k] = num % 10;
            num /= 10;
            --k;
        }
        int[] lastLocOfDigit = new int[10];
        for (int i = 0; i < digits.length; ++i) {
            lastLocOfDigit[digits[i]] = i;
        }
        for (int i = 0; i < digits.length - 1; ++i) {
            int lastLoc = 0;
            for (int j = 0; j < 10; ++j) {
                if (lastLocOfDigit[j] > i) {
                    lastLoc = lastLocOfDigit[j];
                }
            }
            swap(digits, i, lastLoc);
            result = Math.max(result, toNum(digits));
            swap(digits, i, lastLoc);
        }
        return result;
    }
}