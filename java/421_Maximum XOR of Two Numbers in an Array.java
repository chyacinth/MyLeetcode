/**
 * 难，见神算法：https://www.cnblogs.com/charlesblc/p/5966368.html 
 * xor的性质有哪些？ a^b = c, 如果想在集合中找两个元素a,b，使得a^b=c，可以有线性时间的算法
 * a^b=c等价于a=b^c等价于b^c属于集合
 * for (element : set) if (set.contains(element ^ c)) then found:a=element, b=element ^ c
 */
class Solution {
    public int findMaximumXOR(int[] nums) {
        int temp = 0;
        int result = 0;
        int mask = 0;
        for (int i = 31; i >= 0; --i) {
            HashSet<Integer> set = new HashSet<>();
            mask |= (1 << i);
            for (int num : nums) {
                set.add(num & mask);
            }
            temp = result | (1 << i);
            for (int num : set) {
                if (set.contains(num ^ temp)) {
                    result = temp;
                    break;
                }
            }            
        }
        return result;
    }
}