/**
 * Calculate the Euler Path using fleury algorithm (USACO version)
 */ 
class Solution {
public:
  void helper(string v) {    
    while (!adj_list_[v].empty()) {
      string v2 = adj_list_[v].top();
      adj_list_[v].pop();       
      helper(v2);      
    }
    results_.push_back(v);
  }
  vector<string> findItinerary(vector<pair<string, string>> tickets) {
    for (auto &&ticket : tickets) {
      adj_list_[ticket.first].push(ticket.second);            
    }                
    helper("JFK");
    return vector<string>(results_.rbegin(), results_.rend());
  }
private:    
  unordered_map<string, priority_queue<string, vector<string>, greater<string>>> adj_list_;  
  vector<string> results_;
};