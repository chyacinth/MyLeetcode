class Solution {
    List<List<Integer>> results = new ArrayList<>();
    public void findComb(int st, int n, int k, List<Integer> result) {
        if (k == 0) {
            results.add(result);
            return;
        }
        for (int i = st; i <= n - (k - 1); i++) {
            result.add(i);
            findComb(i + 1, n, k - 1, new ArrayList<Integer>(result));
            result.remove(result.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> result = new ArrayList<>();
        findComb(1, n, k, result);
        return results;
    }
}