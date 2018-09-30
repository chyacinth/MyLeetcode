/**
 * Use Edge to record each character of the word
 */ 
class Trie {
public:
    /** Initialize your data structure here. */
    Trie() {
        root = make_shared<TireNode>();
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        shared_ptr<TireNode> p = root;
        for (char &c : word) {
            if (p->edge[c - 'a'] == nullptr) {
                p->edge[c - 'a'] = make_shared<TireNode>();                
            }
            p = p->edge[c - 'a'];
        }
        p->is_word = true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        shared_ptr<TireNode> p = root;
        for (char &c : word) {
            if (p->edge[c - 'a'] == nullptr) {
                return false;
            } else {
                p = p->edge[c - 'a'];
            }
        }
        return p->is_word;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        shared_ptr<TireNode> p = root;
        for (char &c : prefix) {
            if (p->edge[c - 'a'] == nullptr) {
                return false;
            } else {
                p = p->edge[c - 'a'];
            }
        }
        return true;
    }
private:
    struct TireNode {
        shared_ptr<TireNode> edge[26]{};
        bool is_word = false;
    };
    shared_ptr<TireNode> root = nullptr;
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * bool param_2 = obj.search(word);
 * bool param_3 = obj.startsWith(prefix);
 */