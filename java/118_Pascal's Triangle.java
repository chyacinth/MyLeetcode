/*
easy
*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        if (numRows == 0) return results;                
        results.add(Arrays.asList(1));
        for (int i = 2; i <= numRows; i++) {
            List<Integer> result = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                int l = j >= 1?results.get(i - 2).get(j - 1):0;
                int r = j < i - 1?results.get(i - 2).get(j):0;
                result.add(l + r);
            }
            results.add(result);
        }
        return results;
    }
}