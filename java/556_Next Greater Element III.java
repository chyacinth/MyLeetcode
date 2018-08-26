/**
 * The same as getting next permutation
 * find the first i such that num[i] < num[j], then replace num[i]
 * with the smallest and rightest number that is larger than that
 */
class Solution {
    public int nextGreaterElement(int n) {
        boolean hasNext = false;
        StringBuilder str = new StringBuilder(String.valueOf(n));
        if (str.length() <= 1) {return -1;}
        int startOfReverse = 0;
        for (int i = str.length() - 2; i >= 0; --i) {
            if (str.charAt(i) < str.charAt(i + 1)) {
                hasNext = true;
                char min = str.charAt(i + 1);
                int minIdx = i + 1;
                for (int j = i + 1; j < str.length(); ++j) {
                    if (str.charAt(j) > str.charAt(i) && str.charAt(j) <= min) {
                        min = str.charAt(j);
                        minIdx = j;
                    }                    
                }                
                str.setCharAt(minIdx, str.charAt(i));
                str.setCharAt(i, min);
                startOfReverse = i + 1;
                break;
            }
        }
        //if (1==1) return startOfReverse;
        if (!hasNext) {return -1;}
        // reverse substring        
        StringBuilder reversePart = new StringBuilder(str.substring(startOfReverse)).reverse();        
        String result = str.substring(0, startOfReverse) + reversePart.toString();
        Long val=Long.parseLong(result);
        if (val>Integer.MAX_VALUE){
            return -1;
        } else {
            return val.intValue();
        }
    }
}