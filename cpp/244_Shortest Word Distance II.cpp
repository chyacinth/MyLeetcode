/**
 * Use a map to record the location of each word, in ascending order.
 * Then for each word1, find all its locations. Then use binary search
 * to find the closest location of word2
 */ 
class WordDistance {
public:
  WordDistance(vector<string> words) {
    for (int i = 0; i < words.size(); ++i) {      
      word_locs_map_[words[i]].push_back(i);
    }
  }
  
  int searchPos(int pos, const vector<int> pos_list) {
    int l = 0;
    int r = pos_list.size() - 1;
    int result = r;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (pos_list[mid] < pos) {
        l = mid + 1;
      } else if (pos_list[mid] > pos) {
        r = mid - 1;
        result = mid;
      } else {
        return mid;
      }
    }
    return result;
  }
    
  int shortest(string word1, string word2) {
    vector<int> *target_word_list;
    vector<int> *source_word_list;
    if (word_locs_map_[word1].size() < word_locs_map_[word2].size()) {
      target_word_list = &word_locs_map_[word2];
      source_word_list = &word_locs_map_[word1];
    } else {
      target_word_list = &word_locs_map_[word1];
      source_word_list = &word_locs_map_[word2];
    }
    int result = INT_MAX;
    for (int pos1 : *source_word_list) {
      int pos2 = searchPos(pos1, *target_word_list);
      if (pos2 == 0) {
        result = min(result, abs((*target_word_list)[pos2] - pos1));
      } else {
        result = min({result, abs((*target_word_list)[pos2] - pos1), abs((*target_word_list)[pos2 - 1] - pos1)});
      }      
    }
    return result;
  }
private:
  unordered_map<string, vector<int>> word_locs_map_;
};

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */