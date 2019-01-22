/**
 * Draw a graph, which is very easy
 */ 
class Solution {
public:
    vector<vector<string>> findDuplicate(vector<string>& paths) {
        unordered_map<string, vector<string>> contentToPath;
        istringstream is;
        for (string &file_group : paths) {
            is.clear();
            is.str(file_group);
            string path;
            is >> path;
            string file;
            while (is >> file) {
                int left_parenthesis_loc = file.find('(');
                int right_parenthesis_loc = file.find_last_of(')');
                string content = file.substr(left_parenthesis_loc, right_parenthesis_loc - left_parenthesis_loc + 1); 
                string file_name = file.substr(0, left_parenthesis_loc);
                contentToPath[content].push_back(path + '/' + file_name);
            }            
        }
        vector<vector<string>> result;
        for (auto &kv_pair : contentToPath) {            
            if (kv_pair.second.size() > 1) {
                result.push_back(move(kv_pair.second));
            }
        }
        return result;
    }
};