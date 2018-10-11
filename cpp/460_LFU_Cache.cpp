/**
 * Difficult. We use 3 maps and a valuable min to record the minimum frequency in the cache.
 * 1st map: key -> (value, frequency)
 * 2nd map: frequency -> [key1, key2, ...]
 * 3rd map: key -> iterator of key in 2nd map
 */ 
class LFUCache {
 public:
  LFUCache(int capacity) {
    capacity_ = capacity;
  }
    
  int get(int key) {
    if (key_pair_map_.find(key) == key_pair_map_.end()) {
      return -1;
    } else {
      ++key_pair_map_[key].second;
      freq_keys_map_[key_pair_map_[key].second - 1].erase(key_iter_map_[key]);
      freq_keys_map_[key_pair_map_[key].second].push_back(key);
      key_iter_map_[key] = --(freq_keys_map_[key_pair_map_[key].second].end());
      if (min_ == key_pair_map_[key].second - 1 && freq_keys_map_[min_].empty()) {
        ++min_;
      }
      return key_pair_map_[key].first;
    }
  }
    
  void put(int key, int value) {
    if (capacity_ <= 0) { return; }
    get(key);
    if (key_pair_map_.find(key) != key_pair_map_.end()) {
      key_pair_map_[key].first = value;
    } else {
      if (size_ < capacity_) {
        if (min_ > 1) { min_ = 1; }
        key_pair_map_[key] = {value, 1};
        freq_keys_map_[1].push_back(key);
        key_iter_map_[key] = --(freq_keys_map_[1].end());
        ++size_;
      } else {
        int key_removed = *(freq_keys_map_[min_].begin());
        key_pair_map_.erase(key_pair_map_.find(key_removed));
        freq_keys_map_[min_].erase(freq_keys_map_[min_].begin());
        key_iter_map_.erase(key_iter_map_.find(key_removed));
        
        key_pair_map_[key] = {value, 1};
        freq_keys_map_[1].push_back(key);
        key_iter_map_[key] = --freq_keys_map_[1].end();
        min_ = 1;
      }
    }    
  }
 private:
  int capacity_ = 0;
  int size_ = 0;
  int min_ = 1;
  unordered_map<int,pair<int,int>> key_pair_map_;
  unordered_map<int, list<int>> freq_keys_map_;
  unordered_map<int, list<int>::iterator> key_iter_map_;
};

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
/**
 * ["LFUCache","put","get","put","get","get"]
    [[1],[2,1],[2],[3,2],[2],[3]]
 */