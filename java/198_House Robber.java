/**
 * 简单dp，注意压缩空间
 */
class Solution {
    public int rob(int[] nums) {        
        int gt = 0, ngt = 0, gtTmp, ngtTmp;
        for (int i = 0; i < nums.length; i++) {            
            gtTmp = gt;
            gt = ngt + nums[i];
            ngt = Math.max(gtTmp, ngt);
        }        
        return Math.max(gt, ngt);    
    }
}