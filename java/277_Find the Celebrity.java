/**
 * 怪题，最重要的就是第一个循环，我的理解是假设一定存在celebrity，那么循环第i次找的就是前i个人里面
 * 的那个celebrity，由数学归纳法可证（由所有人一定认识celebrity这一性质易证）
 * 之后只要检验是否是真的celebrity即可，因为celebrity一定不认识celebrity之后的人（循环中已经验证，
 * 所以只要验证是否所有人认识celebrity以及celebrity是否认识前面的人即可）
 */
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int celebrity = 0;
        for (int i = 1; i < n; ++i) {
            if (knows(celebrity, i)) {
                celebrity = i;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (i != celebrity) {
                if (knows(celebrity, i) || !knows(i, celebrity)) {
                    return -1;
                }
            }
        }
        return celebrity;
    }
}