class Solution {
public:
  int countPrimes(int n) {
    int result = 0;
    for (int i = 2; i < n; ++i) {
      result += isPrime(i);
    }
    return result;
  }
private:
  bool isPrime(int n) {
    if (n == 2) return true;
    for (int i = 2; i <= static_cast<int>(sqrt(n)); ++i) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
};