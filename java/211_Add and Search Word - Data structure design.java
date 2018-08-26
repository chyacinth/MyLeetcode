/**
 * Use tire tree to record all words
 */
class WordDictionary {
    
    TrieNode root;
        
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode(' ');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            if (node.subNodes[word.charAt(i) - 'a'] == null) {
                node.subNodes[word.charAt(i) - 'a'] = new TrieNode(word.charAt(i));            
            }
            node = node.subNodes[word.charAt(i) - 'a'];
            if (i == word.length() - 1) {
                node.isWord = true;
            }
        }
    }    
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchHelper(root, word);
    }        
    
    public boolean searchHelper(TrieNode node, String word) {
        if (word.length() <= 0) { return node.isWord; }        
        String subWord = word.substring(1);
        if (word.charAt(0) == '.') {
            boolean found = false;
            
            for (int j = 0; j < 26; ++j) {
                if (node.subNodes[j] != null) { found |= searchHelper(node.subNodes[j], subWord); }
            }
            return found;
        } else if (node.subNodes[word.charAt(0) - 'a'] != null) {
            return searchHelper(node.subNodes[word.charAt(0) - 'a'], subWord);
        } else { return false; }        
    }
    
    class TrieNode {
        TrieNode[] subNodes;
        char ch;
        boolean isWord = false;
        TrieNode(char ch) {
            this.ch = ch;
            subNodes = new TrieNode[26];
            Arrays.fill(subNodes, null);
        }        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */