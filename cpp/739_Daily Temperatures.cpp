/**
 * 单调队列
 **? 
class Solution {
public:
  vector<int> dailyTemperatures(vector<int>& T) {
    vector<int> result(T.size());
    stack<pair<int, int>> mq;
    for (int i = T.size() - 1; i >= 0; --i) {      
      while (!mq.empty() && mq.top().first <= T[i]) {
        mq.pop();
      }      
      if (!mq.empty() && mq.top().second != i) {
        result[i] = mq.top().second - i;
      }
      mq.push({T[i], i});
    }
    return result;
  }
};