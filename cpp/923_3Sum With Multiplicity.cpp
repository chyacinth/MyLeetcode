/*
    Simple 3Sum. 这题等价于求所有使得值为target的组合。所以可以先排序，去除重复，然后3Sum。
    只是在算结果的时候要用一下组合公式。
 */
class Solution {
public:
    int threeSumMulti(vector<int>& A, int target) {
        vector<long> count(101);
        vector<int> num;
        for (const int a : A) {
            if (++count[a] == 1) {
                num.push_back(a);                
            }
        }
        
        sort(num.begin(), num.end());
        
        long result = 0;
        
        constexpr int MOD = 1000000000 + 7;
        
        for (int i = 0; i < num.size(); ++i) {
            for (int j = i; j < num.size(); ++j) {
                int n1 = num[i];
                int n2 = num[j];
                int n3 = target - n1 - n2;
                if (n3 < n2) break;
                if (n3 > 100 || count[n3] == 0) continue;
                if (n1 == n2 && n2 == n3) {
                    long n = count[n1];
                    result += n * (n - 1) * (n - 2) / 6 % MOD;
                } else if (n1 == n2) {
                    long n = count[n1];
                    result += count[n3] * n * (n - 1) / 2 % MOD;
                } else if (n2 == n3) {
                    long n = count[n2];
                    result += count[n1] * n  * (n - 1) / 2 % MOD;
                } else {
                    result += count[n1] * count[n2] * count[n3] % MOD;
                }
                result %= MOD;
            }
        }
        return result;
    }
};