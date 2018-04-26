public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public boolean isPalindrome2(String s, int st, int end) {
        int l = st, r = end;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {return false;}
            l += 1;
            r -= 1;
        }
        return true;
    } 
    
    public List<List<String>> partition(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (isPalindrome2(s, i, j)) {isPalindrome[i][j] = true;}
                else {isPalindrome[i][j] = false;}
            }
        }
        // write your code here
        List<List<String>> results = new ArrayList<List<String>>();
        List<List<String>> partResult;
        for (int i = 0; i < s.length() - 1; i++) {
            if (isPalindrome[i + 1][s.length() - 1]) {
                partResult = partition(s.substring(0, i + 1));
                if (!partResult.isEmpty()) {
                
                    for (int j = 0; j < partResult.size(); j++) {
                        partResult.get(j).add(s.substring(i + 1, s.length()));
                        results.add(partResult.get(j));
                    }
                }
            }
        }
        if (isPalindrome[0][s.length() - 1]) {
            results.add(new ArrayList<String>(Arrays.asList(s)));
        }
        return results;
    }
}