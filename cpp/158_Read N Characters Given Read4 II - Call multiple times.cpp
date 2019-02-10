// Forward declaration of the read4 API.
int read4(char *buf);

class Solution {
public:
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    int read(char *buf, int n) {
        int ret = 0;
        if (n <= length) {
            for (int i = 0; i < n; ++i) {
                buf[ret++] = ch.front();
                ch.pop_front();
                ch.push_back(0);
            }
            length -= n;
            return ret;
        } else {
            for (int i = 0; i < length; ++i) {
                buf[ret++] = ch.front();
                ch.pop_front();
                ch.push_back(0);
            }            
            n -= length;
            length = 0;
            int buf_len = 0;            
            do {
                char* new_buf = new char[5];
                buf_len = read4(new_buf);                
                if (n - buf_len >= 0) {
                    n -= buf_len;
                    for (int i = 0; i < buf_len; ++i) {
                        buf[ret++] = new_buf[i];
                    }
                } else {
                    cout << buf_len << " " << n << endl;                    
                    for (int i = 0; i < n; ++i) {
                        buf[ret++] = new_buf[i];
                    }
                    for (int i = n; i < buf_len; ++i) {
                        ch[i - n] = new_buf[i];
                    }                    
                    length = buf_len - n;
                    n = 0;
                }
                delete[] new_buf;
            } while (buf_len != 0 && n > 0);
                        
            return ret;
        }
    }
private:
    deque<char> ch = deque<char>(4);
    int length = 0;
};