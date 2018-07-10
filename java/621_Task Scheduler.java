/**
 * 仔细思考思考！！ 找出出现频率最高的任务，例如：A，出现频率为3，间隔为2，则至少需要AXXAXXA，
 * 然后如果剩下的元素出现次数少于A，则可以把X全部填充完，具体方法为：把AXX成为你一个frame，
 * 找到另一个任务B，frame1，frame2,...，framen，然后下一个任务从framen+1填充，
 * 如果遇到最后一个frame，则下一次从frame1开始。因此出现次数比A少，所以一定不会出现在同一个frame里填两次，
 * 而因为每一个frame都是均匀减少的，因此最后一定能把任务全填完或把X全填完。X就是体系结构里的bubble
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        int max = 0;
        int existCnt = 0;
        for (int i = 0; i < tasks.length; ++i) {
            cnt[tasks[i] - 'A'] += 1;
        }
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] > max) {
                max = cnt[i];
                existCnt = 1;
            }
            else if (cnt[i] == max) {
                existCnt += 1;
            }
        }
        return Math.max(tasks.length, (n + 1) * (max - 1) + existCnt);
    }
}