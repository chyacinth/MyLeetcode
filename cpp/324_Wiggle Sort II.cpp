/**
 * Very Hard
 * 见题解，follow up巨tm难
 * 
 * 
 * 草草草草草，你他妈写了这么久代码连个Three Way Partition都你妈不会写？？？草草草草草
 **/ 
class Solution {
public:
    void wiggleSort(vector<int>& nums) {
        int n = nums.size();        
        nth_element(nums.begin(), nums.begin() + nums.size()/2, nums.end());
        int m1 = nums[nums.size()/2];
        int m2 = m1;
        if (n % 2 == 0) {
            nth_element(nums.begin(), nums.begin() + nums.size()/2 - 1, nums.end());
            m2 = nums[nums.size()/2 - 1];
        }
        double medium = static_cast<double>(m1 + m2) / 2;
        cout << medium << endl;
        auto m = [n](int i) -> int {
            if (2*i < n) {
                return 2*((n-1)/2 - i);
            } else {
                return 2*n - 2*i - 1;
            }
        };
        int p = -1;
        int q = n;
        while (p + 1 < n && nums[m(p + 1)] == medium) { ++p; }
        while (q - 1 >= 0 && nums[m(q - 1)] == medium) { --q; }
        int i = p + 1;
        int j = q - 1;        
        // 3 way partition
        int start = 0, end = n-1; 
  
        // Traverse elements from left 
        for (int i=0; i<=end;) 
        { 
            // If current element is smaller than 
            // range, put it on next available smaller 
            // position. 
            if (nums[m(i)] < medium) 
                swap(nums[m(i++)], nums[m(start++)]); 
  
            // If current element is greater than 
            // range, put it on next available greater 
            // position. 
            else if (nums[m(i)] > medium) 
                swap(nums[m(i)], nums[m(end--)]);
  
            else
                i++; 
        } 
        for (int i = 0; i < n; ++i) {
            //cout << m(i) << " ";
            cout << nums[m(i)] << " ";
        }
    }
};