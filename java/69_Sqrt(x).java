/*
这题有一个要注意的地方就是，二分法的话在算mid^2的时候会超界，所以要实现判断mid会不会超界
另外，二分法还是l,r代表数组的左端和右端好，之前那种写法（右端表示最后一个元素再后一个）在极端情况会出错，切记！
*/
class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x, mid = 0, result = -1;        
        while (l <= r) {
            mid = (l + r) / 2;            
            if (mid > 46340) {
                r = mid - 1;                
                continue;
            }
            int midSqu = mid * mid;            
            if (midSqu > x) {r = mid - 1;}
            else if (midSqu < x) {
                if (result < midSqu) {result = mid;}
                l = mid + 1;
            }
            else if (midSqu == x) return mid;
        }
        return result;
    }
}