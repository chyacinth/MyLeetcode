/**
 * If we do not want to change the order of the string, we should use
 * stable_sort
 */ 
class Solution {
public:
    string frequencySort(string s) {
        vector<int> occur(256);
        vector<int> index(256);
        for (int i = 0; i < index.size(); ++i) {
            index[i] = i;
        }
        for (char &ch : s) {
            ++occur[ch];
        }
        string result;
        stable_sort(index.begin(), index.end(), [&occur](int x1, int x2){return occur[x1] > occur[x2];});
        for (int i = 0; i < index.size(); ++i) {
            for (int j = 0; j < occur[index[i]]; ++j) {
                result += static_cast<char>(index[i]);
            }
        }
        return result;
    }
};