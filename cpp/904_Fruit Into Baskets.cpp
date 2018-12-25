/*
 动态规划，每次循环记录末尾为i时的最长序列，维护i-1时篮子里装的的两个数和i-1的这个数连续出现的次数。
 然后可以很容易地计算出装i数时的情况
*/
class Solution {
public:
    int totalFruit(vector<int>& tree) {
        int mono_start = 0;
        int cnt = 0;
        int result = 0;
        int *first_num = nullptr, *second_num = nullptr;
        for (int i = 0; i < tree.size(); ++i) {
            int &fruit = tree[i];            
            if (first_num == nullptr) {
                first_num = &fruit;
                cnt = 1;
            } else if (fruit != *first_num and second_num == nullptr) {
                second_num = &fruit;
                ++cnt;
            } else {
                if (fruit == *first_num or fruit == *second_num) {
                    ++cnt;
                } else {
                    cnt = i - mono_start + 1;                    
                    if (*first_num != tree[i-1]) { first_num = &fruit; }
                    if (*second_num != tree[i-1]) { second_num = &fruit; }
                }
            }
            result = max(result, cnt);            
            if ((i > 0) and (tree[i] != tree[i-1])) {                
                mono_start = i;
            }
        }
        return result;
    }
};