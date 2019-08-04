class Solution {
    private boolean isDist(int x1, int x2, int x3, int x4) {
        return (x2 <= x3 || x4 <= x1);
    }
    
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (!isDist(rec1[0], rec1[2], rec2[0], rec2[2]) && 
                !isDist(rec1[1], rec1[3], rec2[1], rec2[3]));
    }
}