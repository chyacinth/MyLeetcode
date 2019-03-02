/**
 * 在一个循环中，用std::map记录第i位之后所有的A[i]和他们的出现位置。
 * 然后用lower_bound和upper_bound找到下一个跳到的位置。
 * 使用DP记录总数
 */ 
class Solution {
public:
    int oddEvenJumps(vector<int>& A) {
        int n = A.size();
        if (n == 0) return 0;
        map<int, vector<int>> rem;
        vector<int> odd_jp(n, 1);
        vector<int> even_jp(n);
        
        for (int i = n - 1; i >= 0; --i) {
            rem[A[i]].push_back(i);
        }
        
        int result = 0;
        for (int i = 0; i < n; ++i) {
            rem[A[i]].pop_back();
            if (rem[A[i]].empty()) {
                rem.erase(A[i]);
            }
            
            // odd jump            
            auto next_it = rem.lower_bound(A[i]);
            if (next_it != rem.end() && !next_it->second.empty()) {                
                int next_id = next_it->second.back();                
                //cout << "odd" << A[i] << " " << next_id << endl;
                even_jp[next_id] += odd_jp[i];
            }
            // even jump
            next_it = rem.upper_bound(A[i]);
            if (next_it != rem.begin()) {
                --next_it;
            } else {
                next_it = rem.end();
            }
            if (next_it != rem.end() && !next_it->second.empty()) {
                int next_id = next_it->second.back();
                //cout << "even" << A[i] << " " << next_id << endl;
                odd_jp[next_id] += even_jp[i];
            }
        }
        
        return odd_jp[n - 1] + even_jp[n - 1];
    }
};