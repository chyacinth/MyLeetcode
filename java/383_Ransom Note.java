/**
 * 空间换时间
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomRecord = new int[26];
        int[] magazineRecord = new int[26];
        for (int i = 0; i < ransomNote.length(); ++i) {
            ++ransomRecord[ransomNote.charAt(i) - 'a'];
        }
        for (int i = 0; i < magazine.length(); ++i) {
            ++magazineRecord[magazine.charAt(i) - 'a'];
        }
        for (int i = 0; i < 26; ++i) {
            if (ransomRecord[i] > magazineRecord[i]) { return false; }
        }
        return true;
    }
}