class Solution {
public:
    bool canCross(vector<int>& stones) {
        int n = stones.size();
        vector<vector<unsigned char>> dp(n, vector<unsigned char>(n));
        unordered_map<int, int> loc_id_mp;
        
        if (stones[1] != 1) return false;
        
        dp[0][0] = true;
        dp[0][1] = true;
        dp[1][1] = true;
        loc_id_mp[0] = 0;
        loc_id_mp[1] = 1;
            
        bool result = false;
        
        for (int i = 1; i < n; ++i) {
            dp[i][i] = true;
            loc_id_mp[stones[i]] = i;
            
            for (int j = i - 1; j >= 0; --j) {
                int dist = stones[i] - stones[j];
                if (loc_id_mp.find(stones[j] - dist) != loc_id_mp.end()) {
                    dp[j][i] |= dp[loc_id_mp[stones[j] - dist]][j];
                }
                if (loc_id_mp.find(stones[j] - dist - 1) != loc_id_mp.end()) {
                    dp[j][i] |= dp[loc_id_mp[stones[j] - dist - 1]][j];
                }
                if (loc_id_mp.find(stones[j] - dist + 1) != loc_id_mp.end()) {
                    if (loc_id_mp[stones[j] - dist + 1] != j) {
                        dp[j][i] |= dp[loc_id_mp[stones[j] - dist + 1]][j];
                    }
                }
                if (i == n - 1) {
                    result |= dp[j][i];                    
                }
            }
        }
        return result;
    }
};