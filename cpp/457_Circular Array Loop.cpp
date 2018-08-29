/**
 * It should be a simple find-a-loop-with-O(1)-space problem, which
 * generally use fast-slow pointer to find the entry of the loop,
 * then traverse the loop to find whether each element in the loop 
 * has the same direction.
 * But the vague requirement makes understanding the problem correctly
 * very difficult.
 */ 
class Solution {
public:
  int sign(int num) {
    return (num > 0)?1:-1;
  }
  bool circularArrayLoop(vector<int>& nums) {
    int len = nums.size();      
    if (len == 0) return false;
    bool result = false;
    for (int i = 0; i < len; ++i) {
      if (result) {
        return result;
      }
      if (nums[i] == 0) { continue; }    
      int slow = i;
      int fast = i;
      do {
        slow = (slow + nums[slow] + len) % len;
        fast = (fast + nums[fast] + len) % len;
        fast = (fast + nums[fast] + len) % len;
      } while (slow != fast);
      fast = i;    
      while (fast != slow) {
        slow = (slow + nums[slow] + len) % len;
        fast = (fast + nums[fast] + len) % len;
        fast = (fast + nums[fast] + len) % len;
      }    
      int st = fast;    
      int direction = sign(nums[st]);
      int cycle_len = 0;        
      do {
        if (direction != sign(nums[slow])) {        
          result |= false;
          break;
        }
        ++cycle_len;
        int prev_slow = slow;
        slow = (slow + nums[slow] + len) % len;
        nums[prev_slow] = 0;
      } while (slow != st);    
      if (slow == st) {
        result |= (cycle_len != 1);
      }
    }
    return result;
  }
};