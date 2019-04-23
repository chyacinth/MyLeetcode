/**
 * 难题，其实挺简单。因为(x,y)->(x+y,y) or (x, x+y)，所以我们通过比较(a,b)哪个大就可以知道
 * 上一步是什么，然后逐步后退，直到顶点。但这样很慢，所以我们发现(a,b)，如果b很大，其实b会不断减a，最后的结果其实就是(a, b%a)，
 * 所以一步就完事了。但注意为了不让(sx,sy)被跳过，以上步骤只能在(a,b) > (sx,sy)时执行（因为这样不会跳过(sx,sy))。如果有一个相等，那么就要特殊处理。
 * 以及当(a==b)的时候也要特殊处理。
 **/ 
class Solution {
public:
    bool reachingPoints(int sx, int sy, int tx, int ty) {
      while (sx < tx && sy < ty) {
        if (tx < ty) ty %= tx;
        else if (tx > ty) tx %= ty;
        else return false;
      }
      return (tx == sx && (ty > sy && (ty - sy) % tx == 0) ||
             ty == sy && (tx > sx && (tx - sx) % ty == 0));
    }
};