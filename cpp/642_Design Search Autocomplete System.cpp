/**
 * Difficult. Use Trie Tree to record all string. (not only in the leaf node but in each node on the path)
 * each node have a insert and search function
 **/ 
class AutocompleteSystem {
public:
    AutocompleteSystem(vector<string> sentences, vector<int> times) {        
        for (int i = 0; i < sentences.size(); ++i) {
            head.insertStr(sentences[i], sentences[i], times[i]);
        }
    }
    
    vector<string> input(char c) {
        vector<string> result;
        if (c == '#') {
            cout << last_string << endl;
            head.insertStr(last_string, last_string, 1);
            last_string = "";
            node = &head;
            return result;
        }
        last_string += c;
        if (!node) {
            return result;
        }
        result = node->search(c);
        int child_id = c == ' ' ? 26 : c - 'a';        
        node = node->children[child_id].get();
        return result;
    }
    
private:
    struct TrieNode {
        TrieNode() = default;
    
        void insertStr(const string &remain_str, const string &insert_str, int count) {
            bool inserted = false;
            for (auto &p : count_sentence) {
                if (p.second == insert_str) {
                    p.first += count;
                    inserted = true;
                    break;
                }
            }
            if (!inserted) {
                count_sentence.push_back({count, insert_str});
            }

            sort(count_sentence.begin(), count_sentence.end(), 
                 [](const pair<int, string> &p1, const pair<int, string> &p2){
                     return (p1.first > p2.first) || (p1.first == p2.first && p1.second < p2.second);
                 });
        
            if (remain_str.empty()) { return; }
            int child_id = remain_str[0] == ' ' ? 26 : remain_str[0] - 'a';        
            if (!children[child_id]) {
                children[child_id] = make_unique<TrieNode>();            
            }
        
            children[child_id]->insertStr(remain_str.substr(1, remain_str.size() - 1), insert_str, count);
            return;
        }
    
        vector<string> search(char c) {
            vector<string> result;
            int child_id = c == ' ' ? 26 : c - 'a';        
            if (children[child_id]) {
                for (auto p : children[child_id]->count_sentence) {
                    if (p.first){
                        result.push_back(p.second);
                    }
                    if (result.size() >= 3) {
                        break;
                    }
                }            
            }
            return result;
        }
    
        unique_ptr<TrieNode> children[27];
        vector<pair<int, string>> count_sentence = vector<pair<int, string>>();
    };
    
    TrieNode head = TrieNode();
    TrieNode *node = &head;
    string last_string;
};

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * vector<string> param_1 = obj.input(c);
 */