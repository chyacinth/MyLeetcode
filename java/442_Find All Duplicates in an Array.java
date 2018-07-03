/**
 * 让a[i]=i+1，发现不符合的就将a[i]交换到应该到的地方，如果应该到的地方有a[i]了，则说明a[i]重复,i+=1。否则i不变，看新的a[i]什么情况
 */
class Solution {
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> result = new ArrayList<>();
    int i = 0;
    
    while (i < nums.length) {
      if (nums[i] < 0) {
        i += 1;
        continue;
      }
      if (nums[i] == i + 1) {
        i += 1;
        continue;
      } else {
        if (nums[nums[i] - 1] == nums[i]) {
          result.add(nums[i]);
          nums[i] = -1;
        }
        else {
          int temp = nums[nums[i] - 1];
          nums[nums[i] - 1] = nums[i];
          nums[i] = temp;
        }
      }
    }
    return result;
  }
}