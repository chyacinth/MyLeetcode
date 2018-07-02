/**
 * 这种数组存的数和数组大小很接近的题一般两种做法：
 * 1. 看成链表
 * 2. 用数组本身作为对数组元素情况的记录
 * 这道题就是两种结合。让数组的a[i]记录数字i+1的出现情况，通过链表的方式来决定元素的访问顺序，使得数组存储的信息能够在被使用后再修改，
 * 避免了因为节省空间而遗失信息的情况。
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                int t = nums[i] - 1, temp = 0;
                while (t >= 0) {
                    temp = nums[t];                    
                    nums[t] = -1;
                    t = temp - 1;
                }                
            }            
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) result.add(i + 1);
        }
        return result;
    }
}