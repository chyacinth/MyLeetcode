class Solution {
public:
    int length(vector<int> &vec) {
        return (vec[0] * vec[0]) + (vec[1] * vec[1]);
    }
    bool validSquareHelper(vector<int>& p1, vector<int>& p2, vector<int>& p3, vector<int>& p4) {
        if (p1 == p2) return false;
        vector<int> v12 = {p1[0]-p2[0], p1[1]-p2[1]};
        vector<int> v34 = {p3[0]-p4[0], p3[1]-p4[1]};
        vector<int> v13 = {p1[0]-p3[0], p1[1]-p3[1]};
        vector<int> v24 = {p2[0]-p4[0], p2[1]-p4[1]};
        return (length(v12) == length(v13) && v12 == v34 &&
               v13 == v24 && v12[0]*v13[0]+v12[1]*v13[1] == 0);
        
    }
    bool validSquare(vector<int>& p1, vector<int>& p2, vector<int>& p3, vector<int>& p4) {        
        return (validSquareHelper(p1, p2, p3, p4) | validSquareHelper(p1, p2, p4, p3) |
                validSquareHelper(p1, p3, p2, p4) | validSquareHelper(p1, p3, p4, p2) |
                validSquareHelper(p1, p4, p2, p3) | validSquareHelper(p1, p4, p3, p2));
        
    }
};