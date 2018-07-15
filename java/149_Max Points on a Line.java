/**
 * 有点难
 * 首先考虑算法：
 * 对每一个点i，我们用O(N)的时间找到所有其它点和点i构成的直线的斜率。使用HashMap进行计数。
 * 那么出现次数最多的斜率，他的出现次数就是最多有多少点和点i共线的个数。对每个点进行这样的计算，得到最多的共线点的个数即可。
 * 时间O(N^2)，空间O(N)
 * 坑点：这题的数据很恶心。有重复的点，而且都算在共线点个数里。因此当我们找到和点i相同的时候，我们要用变量additional记录和点i相同的点
 * 的个数，在结果上加上。还有，HashMap不能简单地把斜率这个double当做key，因为会有那种很接近的数据，超过了double的精度，所以最好是
 * 将斜率用最简分数的形式写。为此需要自定义类Factorial，为了能作为HashMap的key，还需要重写equals和hashCode
 */
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    boolean theSame(Point a, Point b) {
        return (a.x == b.x) && (a.y == b.y);
    }
    
    static class Factorial {        
        public int numerator = 0;
        public int denominator = 0;
        
        Factorial() { numerator = 0; denominator = 0; }
        Factorial(int a, int b) {
            boolean isNegative = (a < 0 && b > 0) || (a > 0 && b < 0);
            numerator = Math.abs(a);
            denominator = Math.abs(b);
            int divisor = gcd(numerator, denominator);
            numerator /= divisor;
            denominator /= divisor;
            if (isNegative) { denominator *= -1; }
        }
        @Override        
        public int hashCode() {
            return Objects.hash(numerator, denominator);
        }
        @Override        
        public boolean equals(Object anObject) {
            if (this == anObject) {
                return true;
            }
            if (anObject instanceof Factorial) {
                return (numerator == ((Factorial)anObject).numerator) && 
                    (denominator == ((Factorial)anObject).denominator);
            } else { return false; }
        }
        static int gcd(int a, int b) {
            if (a < b) {
                int temp = a;
                a = b;
                b = temp;
            }
            if (b != 0) {
                return gcd(b, a % b);
            } else return a;            
        }
    }
    
    Factorial getSlope(Point a, Point b) {
        if (a.y == b.y) return new Factorial(1, 0);
        else if (a.x == b.x) return new Factorial(0, 1);
        else return new Factorial(b.x - a.x, b.y - a.y);
    }
        
    public int maxPoints(Point[] points) {
        if (points.length == 0) return 0;
        int temp = 0;
        int result = 0;
        int additional = 0;
        for (int i = 0; i < points.length; ++i) {
            temp = 0;
            additional = 0;
            HashMap<Factorial, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; ++j) {
                if (!theSame(points[i],points[j])) {                    
                    Factorial slope = getSlope(points[i], points[j]);                    
                    Integer cnt = map.get(slope);
                    if (cnt == null) { 
                        cnt = 1;
                        map.put(slope, 1); 
                    }
                    else { 
                        ++cnt;
                        map.put(slope, cnt); 
                    }
                    temp = Math.max(temp, cnt);
                }
                else { ++additional; }
            }
            result = Math.max(result, temp + additional);
        }
        return result;
    }
}