/*
    一定要注意in_block这个变量的巧妙用法！
*/
class Solution {
public:
    vector<string> removeComments(vector<string>& source) {
        vector<string> results;
        bool in_block = false;
        string temp;
        for (string line : source) {
            if (!in_block) temp.clear();
            for (int i = 0; i < line.size(); ++i) {
                if (!in_block && i + 1 < line.size() && line[i] == '/' && line[i + 1] == '*') {
                    in_block = true;
                    ++i;
                } else if (in_block && i + 1 < line.size() && line[i] == '*' && line[i + 1] == '/') {
                    in_block = false;
                    ++i;
                } else if (i + 1 < line.size() && !in_block && line[i] == '/' && line[i + 1] == '/') {
                    break;
                } else if (!in_block) {
                    temp += line[i];
                }                
            }
            if (!in_block && temp.size() > 0) {
                results.push_back(temp);
            }
        }
        return results;
    }
};