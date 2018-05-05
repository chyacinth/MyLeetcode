class Solution {
    public String addBinary(String a, String b) {
        char[] sum = new char[Math.max(a.length(), b.length()) + 1];
        int ida = a.length() - 1, idb = b.length() - 1;
        int add = 0;
        for (int i = sum.length - 1; i >= 0; i--) {
            sum[i] = '0';            
            if (ida >= 0 && idb >= 0) {
                sum[i] = (char) (a.charAt(ida) + b.charAt(idb) - '0');
            }
            else if (ida >= 0) {
                sum[i] =  a.charAt(ida);
            }
            else if (idb >= 0) {
                sum[i] =  b.charAt(idb);
            }
            sum[i] += add;
            add = (sum[i] - '0') / 2;
            sum[i] = (char) ((sum[i] - '0') % 2 + '0');
            ida -= 1; idb -= 1;
        }
        String result;
        if (sum[0] == '0') {result = new String(sum, 1, sum.length - 1);}
        else result = new String(sum, 0, sum.length);
        return result;
    }
}