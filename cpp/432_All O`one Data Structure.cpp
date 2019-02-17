/**
 * 超级恶心题，我用的是https://leetcode.com/problems/all-oone-data-structure/discuss/91398/C%2B%2B-solution-with-comments
 * 的方法，map+list。注意何时需要加bucket何时需要去除bucket。建议画图
 */ 
class AllOne {
public:
    /** Initialize your data structure here. */
    AllOne() {
        vk_map[0] = buckets.begin();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    void inc(string key) {
        //cout << "start inserting " << key << endl;
        int val = ++kv_map[key];        
        // if is inserting a new bucket
        if (vk_map.find(val) == vk_map.end()) {
            
            vk_map[val] = buckets.insert(std::next(vk_map[val - 1]), unordered_set<string>());
        }
        vk_map[val]->insert(key);
        vk_map[val - 1]->erase(key);
        if (val - 1 != 0 && vk_map[val - 1]->empty()) {
            buckets.erase(vk_map[val - 1]);
            vk_map.erase(val - 1);
        }        
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    void dec(string key) {
        //cout << "start decreasing " << key << endl;
        int val = --kv_map[key];        
        vk_map[val + 1]->erase(key);
        // if is inserting a bucket
        if (vk_map.find(val) == vk_map.end()) {
            vk_map[val] = buckets.insert(vk_map[val + 1], unordered_set<string>());
        }        
        if (val != 0) {
            vk_map[val]->insert(key);
        }
        if (vk_map[val + 1]->empty()) {
            buckets.erase(vk_map[val + 1]);
            vk_map.erase(val + 1);
        }       
    }
    
    /** Returns one of the keys with maximal value. */
    string getMaxKey() {        
        if (buckets.size() <= 1) return "";
        return *(buckets.back().begin());
    }
    
    /** Returns one of the keys with Minimal value. */
    string getMinKey() {        
        if (buckets.size() <= 1) return "";
        return *((++buckets.begin())->begin());
    }
private:
    unordered_map<string, int> kv_map;
    list<unordered_set<string>> buckets = list<unordered_set<string>>(1);
    unordered_map<int, list<unordered_set<string>>::iterator> vk_map;
};

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * string param_3 = obj.getMaxKey();
 * string param_4 = obj.getMinKey();
 */