
/*
格雷码，老朋友了，记得是有公式的，但其实还是可以用递归做，不要忘记递归性质。
*/
class Solution {    
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>(), resultTemp;
        if (n == 0) {
            result.add(0);
        }
        else if (n == 1) {
            result.add(0);
            result.add(1);
            return result;
        } else {
            resultTemp = grayCode(n - 1);
            for (int i = 0; i < resultTemp.size(); i++) {
                result.add(resultTemp.get(i));
            }
            for (int i = resultTemp.size() - 1; i >= 0; i--) {
                result.add(resultTemp.get(i) + (1 << (n - 1)));
            }
        }
        return result;
    }
}