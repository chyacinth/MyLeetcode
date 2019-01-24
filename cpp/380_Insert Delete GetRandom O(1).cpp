/**
 * Use a nums vector to record all the 
 **/ 
class RandomizedSet {
public:
    /** Initialize your data structure here. */
    RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    bool insert(int val) {
        if (value_to_loc.find(val) == value_to_loc.end()) {
            nums.push_back(val);
            value_to_loc[val] = nums.size() - 1;
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    bool remove(int val) {
        int size = nums.size();
        auto val_iter = value_to_loc.find(val);
        if (val_iter != value_to_loc.end()) {
            int loc = val_iter->second;
            swap(nums[size-1], nums[loc]);
            value_to_loc[nums[loc]] = loc;
            value_to_loc.erase(val);
            nums.pop_back();
            return true;
        }
        return false;        
    }
    
    /** Get a random element from the set. */
    int getRandom() {        
        return nums[uniform_int_distribution<int>(0,nums.size() - 1)(gen)];
    }
private:
    random_device rd;
    mt19937 gen{rd()};
    vector<int> nums;
    unordered_map<int, int> value_to_loc;
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * bool param_1 = obj.insert(val);
 * bool param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */