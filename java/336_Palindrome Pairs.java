class Solution {
    
    private static class Trie {
        private Trie[] children = new Trie[26];
        private int id = -1;
        private void insert(String word, int id) {
            Trie node = this;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new Trie();
                }
                 
                node = node.children[ch - 'a'];
            }
            node.id = id;
        }
        private List<Integer> find(String word) {
            List<Integer> result = new ArrayList<>();
            Trie node = this;
            if (node.id >= 0) {
                result.add(node.id);
            }
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                if (node.children[ch - 'a'] != null) {
                    node = node.children[ch - 'a'];
                    if (node.id >= 0) {
                        result.add(node.id);
                    }
                } else {
                    return result;
                }
            }
            return result;
        }
    }
    
    private boolean isPalin(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) { return false; }
            ++i;
            --j;
        }
        return true;
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        Trie root = new Trie();
        for (int i = 0; i < words.length; ++i) {
            String reversedWord = new StringBuilder(words[i]).reverse().toString();
            root.insert(reversedWord, i);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            List<Integer> secondNums = root.find(words[i]);
            if (secondNums.size() > 0) {
                for (int j : secondNums) {
                    if (i != j && isPalin(words[i] + words[j])) {
                        result.add(Arrays.asList(new Integer[]{i, j}));
                    }
                }
            }
        }
        
        root = new Trie();
        for (int i = 0; i < words.length; ++i) {
            root.insert(words[i], i);
        }
        for (int i = 0; i < words.length; ++i) {
            words[i] = new StringBuilder(words[i]).reverse().toString();
        }
        for (int i = 0; i < words.length; ++i) {
            List<Integer> secondNums = root.find(words[i]);
            if (secondNums.size() > 0) {
                for (int j : secondNums) {
                    if (i != j && words[i].length() > words[j].length() && isPalin(words[i] + words[j])) {
                        result.add(Arrays.asList(new Integer[]{j, i}));
                    }
                }
            }
        }
        
        return result;
    }
}