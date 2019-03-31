/**
 * 难题？其实挺简单的。从左往右，对每一面墙，计算墙在的这个点的最高高度。这个可以用二叉搜索树
 * 来快速插入、删除高度，以及返回最高的高度。最高的高度就是集合里加上所有这个点开始的边的高度
 * 并去除所有这个点结束的边。至于在这个点之前的边的高度，因为我们是从左往右算的，所以集合里已经有了。
 * 见 https://zhuanlan.zhihu.com/p/48403793
 **/ 
class Solution {
public:
    vector<pair<int, int>> getSkyline(vector<vector<int>>& buildings) {
        if (buildings.size() == 0) {
            return vector<pair<int, int>>{};
        }
        vector<tuple<int, char, int>> walls;
        for (vector<int> &building : buildings) {
            int start = building[0];
            int end = building[1];
            int height = building[2];
            walls.push_back(make_tuple(start, 's', height));
            walls.push_back(make_tuple(end, 'e', height));
        }
        sort(walls.begin(), walls.end(), [](const auto& t1, const auto& t2){
            auto &[s1, l1, h1] = t1;
            auto &[s2, l2, h2] = t2;            
            return (s1 < s2);
        });
        multiset<int> sets{0};
        vector<pair<int, int>> results;
        int prev_num = -1;
        int prev = 0;
        for (auto &[s, l, h] : walls) {
            //cout << s << " " << l << " " << h << endl;
            if (prev_num == -1) { 
                prev_num = s; 
            } else if (prev_num != s) {
                if (int highest = *(--sets.end()); prev != highest) {
                    results.push_back(make_pair(prev_num, highest));
                }
                prev_num = s;
                prev = *(--sets.end());
            }
            if (l == 's') {
                sets.insert(h);                
            } else {
                sets.erase(sets.find(h));
            }            
        }
        auto &[s, l, h] = walls.back();
        if (int highest = *(--sets.end()); prev != highest) {
            results.push_back(make_pair(s, highest));
        }
        return results;
    }
};