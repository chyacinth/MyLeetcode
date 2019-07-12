/**
 * 卵子题
 */
class Solution {
    public int lengthLongestPath(String input) {
        int result = 0;
        String[] paths = input.split("\n");
        int[] levelToLength = new int[paths.length + 1];
        for (String path : paths) {
            // count level
            int level = 1;
            int i = 0;
            while (path.startsWith("\t", i)) {
                ++level;
                i += 1;
            }
            int pathLen = path.length() - level + 1;
            // path is file
            if (path.contains(".")) {
                result = Math.max(
                    result, 
                    levelToLength[level - 1] + level - 1 + pathLen
                );
            } else {
            // path is folder
                levelToLength[level] = levelToLength[level - 1] + pathLen;
            }
        }
        return result;
    }
}