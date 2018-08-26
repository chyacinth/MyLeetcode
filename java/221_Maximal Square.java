/**
 * We can use the same method as Maximal Rectangle
 * But there is a simpler dp method when computing Maximal Square
 * use dp[i][j] indicates the maximal square edge size with i,j as the 
 * bottom right corner
 * then dp[i][j] = dp[i-1][j-1]+(whether the new edge is all 1, 
 * which can be computed within O(1) time using partial sum)
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;        
        if (n == 0) return 0;
        int m = matrix[0].length;
        if (matrix[0].length == 0) return 0;
        int[] nums = new int[m];
        int[] dp = new int[m];
        Arrays.fill(nums, 0);
        int result = 0;
        int[] smallLeft = new int[m];
        int[] smallRight = new int[m];        
        for (int i = 0; i < n; ++i) {            
            for (int j = 0; j < m; ++j) {
                nums[j] = (matrix[i][j] == '1'?nums[j] + 1:0);
            }
            //find first left num smaller than ith element in nums
            Stack<Integer> stack = new Stack<>();        
            for (int j = 0; j < m; ++j) {
                while (!stack.isEmpty() && nums[stack.peek()] >= nums[j]) {
                    stack.pop();
                }                
                if (stack.isEmpty()) {
                    smallLeft[j] = -1;
                } else {
                    smallLeft[j] = stack.peek();;
                }
                stack.push(j);
            }                        
            
            while (!stack.isEmpty()) { stack.pop(); }            
            
            //find first right num smaller than ith element in nums
            for (int j = m - 1; j >= 0; --j) {
                while (!stack.isEmpty() && nums[stack.peek()] >= nums[j]) {
                    stack.pop();
                }                
                if (stack.isEmpty()) {
                    smallRight[j] = m;
                } else {
                    smallRight[j] = stack.peek();;
                }                
                stack.push(j);
            }                        
            
            for (int j = 0; j < m; ++j) {
                if ((smallRight[j] - smallLeft[j] - 1 >= nums[j])) {
                    if (nums[j] * nums[j] > result) { 
                        result = nums[j] * nums[j];
                    }
                }
            }
        }
        return result;
    }
}