/**
 * 两种方法：
 * 1. 一个数的下一个数是什么是有规律的，可以在log(这个数)的时间内得到，具体怎么做很简单
 * 2. 排序算法，重写顺序，慢！
 */
class Solution {
    public int next(int x, int max) {
        if (x * 10 <= max && x != 0) { return x * 10; }
        while (x + 1 > max) {
            x = x / 10;
        }        
        int resultNext = x + 1;
        while (resultNext % 10 == 0) {
            resultNext /= 10;
        }            
        return resultNext;        
    }
    public List<Integer> lexicalOrder(int n) {        
        List<Integer> result = new ArrayList<>();
        int num = 1;
        for (int i = 1; i <= n; ++i) {
            result.add(num);
            num = next(num, n);
        }        
        return result;
        /*Collections.sort(result, new Comparator<Integer>() {
            @Override
            public int compare(Integer left, Integer right) {
                int lnum = (int)(Math.log(left) / Math.log(10));
                int rnum = (int)(Math.log(right) / Math.log(10));
                double diff;
                if (lnum < rnum) {
                    diff = left * Math.pow(10, rnum - lnum) - right;
                }
                else {
                    diff = left - right * Math.pow(10, lnum - rnum);
                }
                if (diff > 0) { return 1; }
                if (diff < 0) { return -1; }
                else { return lnum - rnum; }
            }
        });
        return result;*/
    }
}