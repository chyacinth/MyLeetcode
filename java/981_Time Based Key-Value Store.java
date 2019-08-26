import java.util.NavigableMap;

class TimeMap {
  
  private Map<String, TreeMap<Integer, String>> map;
  
  /** Initialize your data structure here. */
  public TimeMap() {
    map = new HashMap<>();
  }
    
  public void set(String key, String value, int timestamp) {
    map.computeIfAbsent(key, k -> {
      return new TreeMap<>();
    }).put(timestamp, value);
  }
    
  public String get(String key, int timestamp) {
    if (map.containsKey(key)) {
      NavigableMap<Integer, String> tree = map.get(key);
      Map.Entry<Integer, String> entry = tree.floorEntry(timestamp);
      if (entry == null) { return ""; }
      return entry.getValue();
    } else {
      return "";
    }
  }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */