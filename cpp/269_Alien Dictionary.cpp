/**
 * Use the dictionary to build an order graph. Then use topological sort
 */ 
class Solution {
public:
    void generateOrder(const string & s1, const string & s2, unordered_map<char, vector<char>> &graph) {
        for (int i = 0; i < min(s1.size(), s2.size()); ++i) {
            if (s1[i] != s2[i]) {
                graph[s1[i]].push_back(s2[i]);
                break;
            }
        }
    }
    string alienOrder(vector<string>& words) {
        unordered_set<char> char_set;
        for (auto &word : words) {
            for (auto c : word) {
                char_set.insert(c);
            }
        }
        int n = char_set.size();
        //build the order graph
        unordered_map<char, vector<char>> graph;
        for (int i = 0; i < words.size() - 1; ++i) {
            generateOrder(words[i], words[i + 1], graph);
        }
        //topological sort
        queue<char> bfs;
        unordered_map<char, int> degree;        
        for (auto &kv_pair : graph) {
            for (auto ch : kv_pair.second) {
                ++degree[ch];
            }
        }
        for (auto node : char_set) {
            if (degree[node] == 0) {                
                bfs.push(node);
            }
        }
        string result;        
        while (!bfs.empty()) {
            result += bfs.front();            
            for (auto ch : graph[bfs.front()]) {
                if (--degree[ch] == 0) {
                    bfs.push(ch);
                }
            }
            bfs.pop();
        }
        if (result.size() != char_set.size()) {
            return "";
        }
        return result;
    }
};