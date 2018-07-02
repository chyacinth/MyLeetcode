/**
 * 数学方法
 * 0+nk, 1+nk, 2+nk构成多个循环节，每次在循环节中进行轮换即可。
 * 重点是，如何略过重复的循环节？ 这等价于，a+ck与b+dk在模len下同余
 * 经过数学推导发现等价于方程b-a=m*k+n*len有解，可以用欧几里得定理
 * 所以，设循环i从0到len-1，对循环节i+nk构成的循环做交换，直到当i满足：i>=1 且 上述方程有解时，退出循环
 */
class Solution {
    public void changeWithLoop(int[] nums, int st, int k) {
        int target = (st + k) % nums.length, temp = nums[st];
        while (target != st) {
            nums[st] = temp;
            temp = nums[target];
            nums[target]= nums[st];
            target = (target + k) % nums.length;
        }
        nums[st] = temp;
    }
    
    public int prime(int a, int b) {
        if (a < b) return prime(b, a);
        else {
            if (b == 0) return a;
            else return prime(b, a % b);            
        }
    }
    
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        boolean stopCalc = false;
        int gcd = prime(k, nums.length);        
        if (gcd == 1) changeWithLoop(nums, 0, k);        
        else if (k > 0) {
            for (int i = 0; i < nums.length && i < k; i++) {       
                if (i >= 1 && ((i % k == 0 || i % nums.length == 0 || i % gcd == 0))) {
                    break;
                }                
                changeWithLoop(nums, i, k);
                
            }
        }        
    }
}