class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); ++i) {
            int v1Num = 0;
            if (i < v1.length) {
                v1Num = Integer.parseInt(v1[i]);
            }
            int v2Num = 0;
            if (i < v2.length) {
                v2Num = Integer.parseInt(v2[i]);
            }
            if (v1Num < v2Num) return -1;
            if (v1Num > v2Num) return 1;
        }
        return 0;
    }
}