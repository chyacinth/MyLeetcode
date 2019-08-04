/**
 * 倒着Trie
 */
class StreamChecker {

    private static class TrieNode {
        private TrieNode[] children = null;
        private boolean isWord = false;
    }
    
    private String[] words;
    private TrieNode root = new TrieNode();
    private StringBuilder sb = new StringBuilder();

    public StreamChecker(String[] words) {
        for (String word : words) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; --i) {
                char ch = word.charAt(i);
                if (node.children == null) {
                    node.children = new TrieNode[26];
                }
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.isWord = true;
        }
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode node = root;
        for (int i = sb.length() - 1; i >= 0; --i) {
            char ch = sb.charAt(i);
            if (node.children != null && node.children[ch - 'a'] != null) {
                node = node.children[ch - 'a'];
                if (node.isWord) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return node.isWord;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */