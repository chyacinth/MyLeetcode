/*
    Simple
*/
class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int K) {
        auto comp = [](const vector<int> &point1, const vector<int> &point2){
            return point1[0]*point1[0] + point1[1]*point1[1] < point2[0]*point2[0] + point2[1]*point2[1];
        };
        priority_queue<vector<int>, vector<vector<int>>, decltype(comp)> pq(comp);
        for (auto point : points) {
            pq.push(point);
            if (pq.size() > K) {
                pq.pop();
            }
        }
        vector<vector<int>> ans;
        while (!pq.empty()) {
            ans.push_back(pq.top());
            pq.pop();
        }
        return ans;
    }
};