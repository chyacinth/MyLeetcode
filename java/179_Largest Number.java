/**
 * 比较简单，重排序数组，然后按排序的顺序连接数字。
 * 排序顺序为：比较两个数字a和b，如果a和b以字符串串联的值大于b和a以字符串串联的值，则a在b前，否则互换。
 * 这是因为如果a和b串联的值大，说明将a放在b前面形成的字符串会大。
 */
class Solution {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            strNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String temp = new String(a);
                a += b;
                b += temp;                        
                return b.compareTo(a);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String str : strNums) {
            sb.append(str);
        }
        String result = new String(sb);
        int st = 0;
        for (st = 0; st < result.length(); ++st) {
            if (result.charAt(st) != '0') return result.substring(st, result.length());
        }
        return result.substring(st - 1, result.length());
    }
}