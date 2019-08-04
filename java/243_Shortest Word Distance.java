class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        List<Integer> locOfWord1 = new ArrayList<>();
        List<Integer> locOfWord2 = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            if (word.equals(word1)) {
                locOfWord1.add(i);
            }
            if (word.equals(word2)) {
                locOfWord2.add(i);
            }
        }
        int l = 0;
        int r = 0;
        int result = words.length - 1;
        while (l < locOfWord1.size() && r < locOfWord2.size()) {
            int loc1 = locOfWord1.get(l);
            int loc2 = locOfWord2.get(r);
            result = Math.min(result, Math.abs(loc1 - loc2));
            if (loc1 < loc2) { ++l; }
            else if (loc1 > loc2) { ++r; }
            else {
                ++l;
                ++r;
            }
        }
        return result;
    }
}