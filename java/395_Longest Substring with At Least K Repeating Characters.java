/**
 * 有点难！两种算法：
 * 1. 递归，但是复杂度是？ 
 * 找到字符串s中出现次数不到k的字符，看作“墙”，然后对墙与墙之间的字符串调用递归
 * 2. two pointer O(N)算法，外循环枚举h,即每次双指针法找的是只含有h种英文字母的最长序列
 * 这是可以用双指针法做的
 */
class Solution {        
    public int longestSubstring(String s, int k) {
        int result = 0;
        for (int i = 1; i <= 26; ++i) {
            int l = 0;
            int r = 0;            
            int[] count = new int[26];
            Arrays.fill(count, 0);
            int uniqueCount = 0;
            int greaterOrEqualThanKCount = 0;
            while (r < s.length()) {
                char rChar = s.charAt(r);
                char lChar = s.charAt(l);
                if (count[rChar - 'a'] == 0) {
                    if (uniqueCount + 1 <= i) {
                        ++count[rChar - 'a'];
                        if (count[rChar - 'a'] == k) {
                            ++greaterOrEqualThanKCount;
                        }
                        ++uniqueCount;
                        ++r;
                    } 
                    else {
                        ++l;
                        --count[lChar - 'a'];
                        if (count[lChar - 'a'] == k - 1) {
                            --greaterOrEqualThanKCount;
                        }
                        if (count[lChar - 'a'] == 0) {
                            --uniqueCount;
                        }
                        continue;
                    }
                } else {
                    ++r;
                    ++count[rChar - 'a'];
                    if (count[rChar - 'a'] == k) {
                        ++greaterOrEqualThanKCount;
                    }
                }
                if (greaterOrEqualThanKCount == i) {
                    result = Math.max(result, r - l);
                }
            }
        }
        return result;
    }    
}