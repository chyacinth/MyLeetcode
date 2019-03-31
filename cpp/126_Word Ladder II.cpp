/**
 * 就是一个图论题，找出两点间所有最短路径。一般来说这种题要用BFS，不要用DFS！！切记
 **/ 
class Solution {
public:
    void get_result(const string &s, const string begin_word, 
                    vector<string> &result, unordered_map<string, vector<string>> &parents) {
        if (s == begin_word) {
            reverse(result.begin(), result.end());
            results.push_back(result);
            reverse(result.begin(), result.end());
            return;
        }
        for (string &parent : parents[s]) {
            result.push_back(parent);
            get_result(parent, begin_word, result, parents);
            result.pop_back();
        }
    }
    void helper(const string &begin_word, const string &end_word) {
        queue<string> bfs;
        bfs.push(begin_word);
        unordered_map<string, vector<string>> parents;
        unordered_map<string, int> depth;
        depth[begin_word] = 0;
        while (!bfs.empty()) {            
            const string s = move(bfs.front());
            bfs.pop();
            if (depth.find(end_word) != depth.end() && depth[s] >= depth[end_word]) continue;
            for (const string &s2 : edges[s]) {
                if (depth.find(s2) == depth.end() || depth[s2] > depth[s] + 1) {
                    depth[s2] = depth[s] + 1;
                    parents[s2].clear();
                    parents[s2].push_back(s);
                    bfs.push(s2);
                } else if (depth[s2] == depth[s] + 1) {
                    parents[s2].push_back(s);
                }
            }
        }
        vector<string> result{end_word};
        get_result(end_word, begin_word, result, parents);
        return;
    }
    
    int num_diff(const string &s1, const string &s2) {
        if (s1.size() != s2.size()) {
            return 2;
        }
        int res = 0;
        for (int i = 0; i < s1.size(); ++i) {
            if (s1[i] != s2[i]) ++res;
        }
        return res;
    }
    
    vector<vector<string>> findLadders(string begin_word, string end_word, vector<string>& word_list) {
        bool in_dict = false;
        for (const string &s : word_list) {
            if (end_word == s) {
                in_dict = true;
            }
            for (const string &s2 : word_list) {
                if (num_diff(s, s2) == 1) {
                    edges[s].insert(s2);
                    edges[s2].insert(s);
                }
            }
        }
        for (const string &s2 : word_list) {
            if (num_diff(begin_word, s2) == 1) {
                edges[begin_word].insert(s2);
            }
        }
        if (!in_dict) {
            return vector<vector<string>>{};
        }
        
        helper(begin_word, end_word);
        return results;
        
    }
private:    
    unordered_map<string, unordered_set<string>> edges;   
    vector<vector<string>> results;
    int min_len = 0;
};