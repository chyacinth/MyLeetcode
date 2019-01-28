/**
 * Difficult
 **/ 
class Solution {
public:
    int countTriplets(vector<int>& A) {
        unordered_map<int, int> m;
        for (int a : A) {
            for (int b : A) {
                ++m[a & b];
            }            
        }        
        int result = 0;
        for (auto &p : m) {
            for (int a : A) {
                if ((p.first & a) == 0) {
                    result += p.second;
                }
            }            
        }
        return result;
    }
};