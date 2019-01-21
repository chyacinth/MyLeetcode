/**
 * (n + m) * (m - n + 1) = 2N
 * So let a*b = 2N, if a+b and a-b are odd, then +1
 */
class Solution {
public:    
    bool isPossible(int m, int n) {
        return (m > n) && ((m + n) % 2 == 1) && ((m - n) % 2 == 1);
    }
    int consecutiveNumbersSum(int N) {
        N = 2 * N;
        int result = 0;        
        for (int i = 1; i <= min(N, static_cast<int>(floor(sqrt(N)))); ++i) {
            if (N % i == 0) {
                int m = i;
                int n = N / m;
                //cout << m << " " << n << endl;
                if (m != n) {
                    result += isPossible(m, n) + isPossible(n, m);                    
                } else {
                    result += isPossible(m, n);
                }
            }
        }
        return result;
    }
};