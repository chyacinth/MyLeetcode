/**
 * Use range of sum to indicate which number to choose
 **/ 

class Solution {
public:
    //smallest larger or equal to 
    Solution(vector<int> w) : sum(w.size()) {
        for (int i = 0; i < w.size(); ++i) {
            sum[i] += sum[i - 1] + w[i];
        }
        dis = uniform_int_distribution<int>(1, sum[w.size() - 1]);
    }    
    
    int pickIndex() {
        int randnum = dis(gen);
        int l = 0, r = sum.size() - 1;
        int result = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (sum[mid] < randnum) {
                l = mid + 1;
            } else {
                result = mid;
                r = mid - 1;
            }
        }
        return result;
    }
private:
    vector<int> sum;
    random_device rd;
    mt19937 gen{rd()};
    uniform_int_distribution<int> dis;
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */