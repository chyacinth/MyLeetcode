/**
 * sliding window 的常规做法，使用堆/二叉树维护每个sliding window
 **/ 
class Solution {
public:
  vector<double> medianSlidingWindow(vector<int>& nums, int k) {
    multiset<double> window(nums.begin(), nums.begin() + k);
    auto median = next(window.begin(), (k-1)/2);
    vector<double> result{(*median + ((k % 2 == 0)? (*(next(median))) : (*median)))/2};
    for (int i = k; i < nums.size(); ++i) {      
      window.insert(nums[i]);
      if (nums[i] >= *median && (k % 2 == 0)) {
        ++median;
      } else if (nums[i] < *median && (k % 2 == 1)) {
        --median;
      }
      //cout << "iter: " << i << " after insert: " << *median << " ";
      auto del = window.lower_bound(nums[i-k]);
      if (del == median) {
        ++median;
        window.erase(del);
        if (k % 2 == 0) {
          --median;
        }
      } else {
        if (nums[i-k] <= *median && (k % 2 == 1)) {
          ++median;
        } else if (nums[i-k] > *median && (k % 2 == 0)) {
          --median;
        }      
        window.erase(del);
      }
      auto x = (k % 2 == 0)? (*(next(median))) : (*median); 
      //cout << *median << endl;
      result.push_back((*median + ((k % 2 == 0)? (*(next(median))) : (*median)))/2);
    }
    return result;
  }
};