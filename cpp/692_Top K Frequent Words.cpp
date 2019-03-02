/**
 * 统计频率，然后pq。注意pq的comparator(a, b)是 b在a之上的条件，和排序不同。
 */ 
class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        using Pair = std::pair<string, int>;
        unordered_map<string, int> freq;
        auto comp = [](const Pair &p1, const Pair &p2) {
            return (p2.second < p1.second || (p2.second == p1.second && p2.first > p1.first));
        };
        priority_queue<Pair, vector<Pair>, decltype(comp)> pq(comp);
        
        for (auto &wd : words) {
            ++freq[wd];
        }
        for (auto &wo : words) {
            if (freq[wo] > 0)
                pq.push({wo, freq[wo]});
            freq[wo] = -1;
            if (pq.size() > k) {
                pq.pop();
            }
        }
        vector<string> ans;
        while (!pq.empty()) {
            ans.push_back(pq.top().first);
            pq.pop();
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};