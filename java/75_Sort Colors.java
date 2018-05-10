class Solution {
    public void sortColors(int[] nums) {        
        int zeroPoint = 0, twoPoint = nums.length - 1;        
        int i = 0, tmp;
        while (i <= twoPoint) {            
            if (nums[i] == 0) {                
                nums[i] = nums[zeroPoint];
                nums[zeroPoint] = 0;
                zeroPoint += 1;
                if (i < zeroPoint) i = zeroPoint;
                continue;
            }
            else if (nums[i] == 2) {
                nums[i] = nums[twoPoint];
                nums[twoPoint] = 2;
                twoPoint -= 1;
                continue;
            }
            i += 1;
        }
    }
}