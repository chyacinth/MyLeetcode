class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] splitStr = s.split(" +");
        StringBuilder result = new StringBuilder();
        for (String str : splitStr) {
            StringBuilder temp = new StringBuilder(str);
            result.append(temp.reverse());
            result.append(" ");
        }
        String resultStr = new String(result);
        return resultStr.substring(0, resultStr.length() - 1);
    }
}