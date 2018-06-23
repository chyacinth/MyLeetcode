/**
 * 如果能搞懂样例为什么基本就做出来了。。关键是要搞懂样例为什么
 * 举例：可以测两次，两只猪，最多可以测多少个桶？
 * 答案：9个，为什么？
 * 将桶排列为：
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * 为什么两维？
 * 答案：第一只猪负责确定毒桶在哪一行，第二只猪负责确定哪一列
 * 为什么三行三列？
 * 答案：第一只测两次，如果第一次死，毒桶就在第一行，第二次死，第二行，都不死，第三行。第二只猪同理
 * 
 * 所以(最多测几次+1)^(猪的数量)为最多可测量的桶的数量
 * 
 * 解这种题还是得从最简单情况开始啊啊！！
*/
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        double dim = Math.floor((float)minutesToTest / minutesToDie) + 1;
        return (int)Math.ceil(Math.log(buckets) / Math.log(dim));
    }
}