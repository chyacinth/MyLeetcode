/**
 * Follows the problem description.
 * Two functions: 
 * 1. get the length of a UTF-8 character
 * 2. check whether the byte starts with 10
 */ 
class Solution {
public:
    int getByteLength(int x) {
        if (x >= (1 << 8)) {
            return -1;
        } else {
            int cnt = 0;
            while (x & (1 << 7)) {
                ++cnt;
                x = x << 1;
            }            
            if (cnt == 1 || cnt > 4) { return -1; }
            if (cnt == 0) { ++cnt; }
            return cnt;
        }
    }
    bool startsWithOneZero(int x) {
        return ((x >> 6) == 2);
    }
    bool validUtf8(vector<int>& data) {
        int i = 0;
        while (i < data.size()) {
            int byte_num = getByteLength(data[i]);
            if (byte_num == -1) return false;            
            int j = 1;
            for (j = 1; j < byte_num; ++j) {
                if (i + j >= data.size()) { return false; }
                else {
                    if (!startsWithOneZero(data[i + j])) { return false; }
                }
            }
            i = i + j;
        }
        return true;
    }
};