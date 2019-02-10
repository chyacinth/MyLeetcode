class Solution {
public:
    double mincostToHireWorkers(vector<int>& quality, vector<int>& wage, int K) {
        int num = quality.size();
        vector<int> hp;
        vector<pair<double, int>> wage_p_quality(num);
        for (int i = 0; i < num; ++i) {
            wage_p_quality[i] = {static_cast<double>(wage[i]) / quality[i], i};
        }
        
        sort(wage_p_quality.begin(), wage_p_quality.end());
        
        int sum = 0;
        
        for (int i = 0; i < K - 1; ++i) {
            int id = wage_p_quality[i].second;
            hp.push_back(quality[id]);
            sum += quality[id];
        }
        
        make_heap(hp.begin(), hp.end());
        
        double result = numeric_limits<int>::max();
        
        for (int i = K - 1; i < num; ++i) {                        
            int id = wage_p_quality[i].second;
            double wpq = wage_p_quality[i].first;
            sum += quality[id];
            hp.push_back(quality[id]); push_heap(hp.begin(), hp.end());
            if (hp.size() > K) {
                sum -= hp.front();
                pop_heap(hp.begin(), hp.end()); hp.pop_back(); 
            }
            double wage_tmp = 0;
            result = min(result, sum * wpq);
        }
        
        return result;
    }
};