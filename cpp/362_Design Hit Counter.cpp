/*
    Simple, record the number and its occurrence
*/
class HitCounter {
public:
    /** Initialize your data structure here. */
    HitCounter() {
        
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    void hit(int timestamp) {
        if (records.empty() || records.back().first != timestamp) {
            records.push_back({timestamp, 1});
        } else {
            ++records.back().second;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    int getHits(int timestamp) {
        int result = 0;
        for (int i = records.size() - 1; i >= 0; --i) {
            if (records[i].first >= timestamp - 299) result += records[i].second;
        }
        return result;
    }
private:
    vector<std::pair<int, int>> records; // {num, occur}
};

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */