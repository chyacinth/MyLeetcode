/**
 * 写得和翔一样，需要好好改进！！
 * 1. 颠倒字符串顺序的时候循环只循环到一半！
 * 2. 去除空格的思路应该是：1）找到第一个非空格元素a，2）找到a后的第一个空格b，3）找到b后的第一个非空格元素c
 * a~b-1放入数组，如果c没有找到就不需要在后面加空格
 */
public class Solution {
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        if (ch.length == 0) {return "";}
        reverseStr(ch, 0, ch.length - 1);
        reverseWord(ch);
        return cleanSpace(ch);
    }
    
    public void reverseStr(char[] c, int st, int ed) {
        char tmp;
        for (int i = st; i <= st + (ed - st) / 2; i++) {
            tmp = c[i];
            c[i] = c[st + ed - i];
            c[st + ed - i] = tmp;
        }
        return;
    }
    
    public void reverseWord(char[] c) {
        int l = 0, r = 0;
        while (r < c.length) {
            while (l < c.length && c[l] == ' ') l++;
            r = l;
            while (r + 1 < c.length && c[r + 1] != ' ') r++;
            if (r < c.length) reverseStr(c, l, r);
            l = r + 1;
        }
        return;
    }
    
    public String cleanSpace(char[] c) {
        int len = 0, t = 0;
        while (t < c.length && c[t] == ' ') t++;
        if (t >= c.length) return "";
        c[len] = c[t];
        len++;
        for (int i = t + 1; i < c.length; i++) {
            if (c[i] != ' ') {                
                if (i - 1 >= 0 && c[i - 1] == ' ') {
                    c[len] = ' ';
                    len++;                    
                }
                c[len] = c[i];
                len++;                
            }            
        }        
        return new String(c, 0, len);
    }
}