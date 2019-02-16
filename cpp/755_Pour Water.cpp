/*
    Simple simulation
*/
class Solution {
public:
    int findLeftLoc(const vector<int>& heights, int k) {
        int result = k;
        for (int i = k; i >= 0; --i) {
            if (heights[i] < heights[result]) {
                result = i;
            } else if (heights[i] > heights[result]) {
                break;
            }
        }
        return result;        
    }
    int findRightLoc(const vector<int>& heights, int k) {
        int result = k;
        for (int i = k; i < heights.size(); ++i) {
            if (heights[i] < heights[result]) {
                result = i;
            } else if (heights[i] > heights[result]) {
                break;
            }
        }
        return result;        
    }
    vector<int> pourWater(vector<int>& heights, int V, int K) {
        for (int i = 0; i < V; ++i) {
            int l = findLeftLoc(heights, K);
            if (l == K) {
                int r = findRightLoc(heights, K);
                ++heights[r];
            } else 
                ++heights[l];
        }
        return heights;
    }
};