class Solution {
    public List<String> commonChars(String[] A) {
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String word : A) {
            int[] wordCount = new int[26];
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                wordCount[c - 'a']++;
            }
            for (int i = 0; i < 26; ++i) {
                count[i] = Math.min(count[i], wordCount[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < count[i]; ++j) {
                result.add(((char)('a' + i)) + "");
            }
        }
        return result;
    }
}