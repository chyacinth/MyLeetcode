/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    char[] buffer = new char[4];
    int bufferLen = 0;
    int bufferCnt = 0;
    
    public int read(char[] res, int n) {
        int len = 0;
        while (n > 0 && bufferCnt < bufferLen) {
            res[len++] = buffer[bufferCnt++];
        }
        if (bufferCnt >= bufferLen) {
            bufferCnt = 0;
            bufferLen = 0;
        }
        while (n > 0) {
            bufferLen = read4(buffer);
            if (bufferLen == 0) { break; }
            for (int i = 0; i < bufferLen; ++i) {
                res[len++] = buffer[i];
                --n;
                if (n <= 0) { break; }
            }
        }
        return len;
    }
}