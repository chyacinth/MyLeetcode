/**
 * 难题，见bear笔记
 * MonotonicQueue
*注意：针对以下题目一定要考虑优先队列！！* [https://github.com/xiaoylu/leetcode_category/tree/master/MonotonicQueue](https://github.com/xiaoylu/leetcode_category/tree/master/MonotonicQueue) 
1. *Given a element A[i], find the nearest element larger/smaller than it* （or it+C)
2. *Sliding Max/Min*
3. *Frog Jump/ Other Jump*
一般都是先发现这样的问题可以用优先队列做，然后进行证明：Key observation: Given input arrayA, whenA[l] < A[r] forl < r, then A[l] should never be retuned as the sliding max, if A[r] has entered the sliding window.
 **/  
class Solution {
public:
  int shortestSubarray(vector<int>& A, int K) {
    deque<int> deq;
    int n = A.size() + 1;
    vector<int> sum(n);
    for (int i = 1; i < n; ++i) {
      sum[i] = sum[i - 1] + A[i - 1];
    }
    int st = 0;
    int result = n + 1;
    for (int i = 0; i < n; ++i) {
      //cout << sum[i] << " ";
      while (!deq.empty() && sum[deq.back()] > sum[i]) {
        deq.pop_back();
      }
      deq.push_back(i);
      if (st < deq.size() && sum[deq[st]] <= sum[i] - K) {
        while (st < deq.size() && sum[deq[st]] <= sum[i] - K) {
          ++st;
        }
        --st;
      }
      if (st < deq.size() && sum[deq[st]] <= sum[i] - K) {
        result = min(result, i - deq[st]);
      }
    }
    if (result == n + 1) {
      return -1;
    }
    return result;
  }
};