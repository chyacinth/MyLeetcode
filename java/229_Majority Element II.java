/**
 * Moore Voting Algorithm, aka Boyer-Moore algorithm, brillient
 */
class Solution {    
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> results = new ArrayList<>();        
        if (nums.length == 0) return results;
        int m1 = 0, m1Cnt = 0, m2 = 0, m2Cnt = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == m1) m1Cnt += 1;
            else if (nums[i] == m2) m2Cnt += 1;
            else if (m1Cnt == 0) {                
                m1 = nums[i];                
                m1Cnt += 1;
            }
            else if (m2Cnt == 0) {
                m2 = nums[i];
                m2Cnt += 1;
            }
            else {
                m1Cnt -= 1;
                m2Cnt -= 1;
            }
        }
        
        m1Cnt = 0;
        m2Cnt = 0;
        
        for (int i = 0 ; i < nums.length; i++) {
            if (nums[i] == m1) m1Cnt += 1;    
            if (nums[i] == m2) m2Cnt += 1;
        }
                
        if (m1Cnt > nums.length / 3) results.add(m1);
        if (m2Cnt > (nums.length / 3) && m2 != m1) results.add(m2);
        return results;
    }
}