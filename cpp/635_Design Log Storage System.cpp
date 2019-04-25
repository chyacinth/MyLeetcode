/**
 * 在红黑树中迭代是常数时间
 **/ 
class LogSystem {
public:
  LogSystem() {
  
  }
    
  void put(int id, string timestamp) {
    time_id[timestamp] = id;
  }
    
  vector<int> retrieve(string s, string e, string gra) {
    int start = gra_start[gra];
    for (;start < 6; ++start) {
      for (int i = coord[start * 2]; i < coord[start * 2 + 1]; ++i) {
        s[i] = '0';
        e[i] = '9';
      }
    }
    //cout << s << " " << e << endl;
    auto low = time_id.lower_bound(s);
    auto high = time_id.upper_bound(e);
    //cout << low->first << " " << low->second << endl;
    //cout << high->first << " " << high->second << endl;
    vector<int> result;
    for (; low != high; ++low) {
      result.push_back(low->second);
    }
    return result;
  }
private:
  map<string, int> time_id;
  static constexpr array<int, 12> coord {0, 4, 5, 7, 8, 10, 11, 13, 14, 16, 17, 19};
  unordered_map<string, int> gra_start {{"Year", 1}, {"Month", 2}, {"Day", 3}, {"Hour", 4}, {"Minute", 5}, {"Second", 6}};
};

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem* obj = new LogSystem();
 * obj->put(id,timestamp);
 * vector<int> param_2 = obj->retrieve(s,e,gra);
 */