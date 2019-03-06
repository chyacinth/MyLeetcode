/**
 * 枚举矩阵左下角右上角，然后看左上右下是否在set里。在的话就算面积
 **/ 
class Solution {
public:  
    int minAreaRect(vector<vector<int>>& points) {
        for (auto point : points) {
            point_set.insert(point);
        }
        int result = numeric_limits<int>::max();
        for (auto point1 : points) {
            for (auto point2 : points) {
                if (point1[0] < point2[0] && point1[1] < point2[1]) {
                    vector<int> point3{point1[0], point2[1]};
                    vector<int> point4{point2[0], point1[1]};
                    if (point_set.find(point3) != point_set.end() &&
                       point_set.find(point4) != point_set.end()) {
                        result = min(result, (point2[0] - point1[0]) * (point2[1] - point1[1]));
                    }
                }
            }
        }
        if (result == numeric_limits<int>::max()) {
            result = 0;
        }
        return result;
    }
private:
    set<vector<int>> point_set;
};