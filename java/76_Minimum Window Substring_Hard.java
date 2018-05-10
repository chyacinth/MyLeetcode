/*
略恶心
通过两个Map记录s和t中各个字符的出现次数
然后在s中维护一个头l一个尾指针r
一开始l为0，r增加，直到s(0,r)和t中字符出现次数相同（s有但t没有的字符不算）
判断相同的方法：不是比较整个Map，而是记录有多少字符数量已经匹配(count变量)
找到后，增加l，直到s(l,r)最短，去除多余的前导字符
之后每次用r+1,l+1（滑窗），判断和t中字符匹配情况（即通过维护count变量判断，注意r+1后count检查一次，l+1后count也要检查一次，
不然会错！）
如果通过count发现仍然匹配，则同样增加l，直到s(l,r)最短。因为已经是滑窗维护了，所以一定是越来越短
*/
class Solution {
    public String minWindow(String s, String t) {
        int[] sRecord = new int[256];
        int[] tRecord = new int[256];
        int count = 0, start = 0;
        int minLen = Integer.MAX_VALUE, reStart = 0, tRecLen = 0;
        boolean found = false;
        for (int i = 0; i < t.length(); i++) {
            if (tRecord[(int) t.charAt(i)] == 0) {tRecLen += 1;}
            tRecord[(int) t.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            sRecord[(int) s.charAt(i)]++;
            if (!found) {
                if ((sRecord[(int) s.charAt(i)] == tRecord[(int) s.charAt(i)]) && (tRecord[(int) s.charAt(i)] != 0)) {
                    count += 1;
                    if (count >= tRecLen) {
                        while (count == tRecLen) {
                            sRecord[(int) s.charAt(start)]--;
                            if (sRecord[(int) s.charAt(start)] == tRecord[(int) s.charAt(start)] - 1 && tRecord[(int) s.charAt(start)] != 0) {
                                sRecord[(int) s.charAt(start)]++;
                                break;
                            }
                            start += 1;
                        }

                        found = true;
                        minLen = (i - start + 1);
                        reStart = start;
                    }
                }
            } else {
                if ((sRecord[(int) s.charAt(i)] == tRecord[(int) s.charAt(i)]) && tRecord[(int) s.charAt(i)] != 0) {
                    count += 1;
                }
                sRecord[(int) s.charAt(start)]--;
                if (sRecord[(int) s.charAt(start)] == tRecord[(int) s.charAt(start)] - 1 && tRecord[(int) s.charAt(start)] != 0) {
                    count -= 1;
                }
                start += 1;
                while (count == tRecLen) {
                    sRecord[(int) s.charAt(start)]--;
                    if (sRecord[(int) s.charAt(start)] == tRecord[(int) s.charAt(start)] - 1 && tRecord[(int) s.charAt(start)] != 0) {
                        sRecord[(int) s.charAt(start)]++;
                        break;
                    }
                    start += 1;
                }
                if (count == tRecLen) {
                    minLen = (i - start + 1);
                    reStart = start;
                }
            }
        }
        if (!found) return "";
        return s.substring(reStart, reStart + minLen);
    }
}