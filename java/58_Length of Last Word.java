class Solution {
    public int lengthOfLastWord(String s) {
        int cnt = 0;
        boolean hasChar = false;
        for (int i = s.length() - 1; i >= 0; i--) {            
            if (s.charAt(i) != ' ') {
                cnt += 1;
                hasChar = true;
            }
            else if (hasChar) {break;}
        }
        return cnt;
    }
}