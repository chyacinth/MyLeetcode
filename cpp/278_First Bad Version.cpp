/**
 * Simple binary search.
 * Be careful about overflow of statement: mid = (l + r) / 2
 */ 
// Forward declaration of isBadVersion API.
bool isBadVersion(int version);

class Solution {
public:
  int firstBadVersion(int n) {
    int l = 0;
    int r = n;
    int result = n;
    while (l <= r) {
      long mid = l + (r - l) / 2;
      if (isBadVersion(mid)) {
        result = mid;
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return result;
  }
};