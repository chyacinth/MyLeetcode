//总面积-重叠面积
//重叠面积=横坐标重叠量*纵坐标重叠量
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int result = 0;
        result += (C - A) * (D - B) + (G - E) * (H - F) - 
            Math.max(0, Math.min(Math.min(C - A, G - E), Math.min(C - E, G - A))) * 
            Math.max(0, Math.min(Math.min(D - B, H - F), Math.min(H - B, D - F)));
        return result;
    }
}