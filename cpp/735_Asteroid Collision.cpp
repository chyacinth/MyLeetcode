/**
 * Use a stack to simulate
 */ 
class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        vector<int> ans;
        for (int aster : asteroids) {
            if (ans.empty() || !(ans.back() > 0 && aster < 0)) {
                ans.push_back(aster);                
            } else {
                while (!ans.empty()) {
                    int t = ans.back();
                    if (t < 0 || t >= abs(aster)) {
                        if (t == abs(aster)) {
                            ans.pop_back();
                        }
                        if (t >= abs(aster)) {
                            aster = 0;
                        }                        
                        break;
                    }
                    ans.pop_back();
                }
                if (aster) {
                    ans.push_back(aster);
                }
            }
        }
        return ans;
    }
};