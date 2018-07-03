/**
 * 简单数组题
 * 记录每个元素的出现位置和每个元素的出现次数
 * 只需要找出现最多的那些元素的第一个和最后一个位置，然后作差，找最小的差即可 
 */
class Solution {
    public int findShortestSubArray(int[] nums) {
      int[] start = new int[50000];
      int[] occur = new int[50000];
      int n = nums.length;            
      if (n == 0) return 0;            
      
      int max = 0;
      
      for (int i = 0; i < n; i++) {
        occur[nums[i]]++;
        start[nums[i]] = -1;
        if (occur[nums[i]] > max) {
          max = occur[nums[i]];
        } 
      }
                 
      for (int i = 0; i < n; i++) {
        if (start[nums[i]] < 0) {
          start[nums[i]] = i;
        }
                
      }
      
      int result = n;      
      for (int i = n - 1; i >= 0; i--) {
        if (occur[nums[i]] == max) {          
          int len = i - start[nums[i]] + 1;
          if (result > len) {
            result = len;            
          }
          occur[nums[i]] = -1;
        }
      }
      return result;
    }  
}