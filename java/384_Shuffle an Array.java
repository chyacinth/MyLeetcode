/**
 * 通过随机交换来达到shuffle的目的
 */
class Solution {
    
    int[] res;
    int[] nums;
    int n;
    Random rand = new Random();
    
    public Solution(int[] nums) {
        this.nums = nums;
        n = this.nums.length;
        res = Arrays.copyOf(nums, n);
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        res = Arrays.copyOf(nums, n);
        return res;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < n; ++i) {
            int randNum = rand.nextInt(n - i) + i;
            int temp = res[i];
            res[i] = res[randNum];
            res[randNum] = temp;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */