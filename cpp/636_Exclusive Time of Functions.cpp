/*
    stack，然后考虑debt数组（即上一层的函数运行的时间要在当层扣掉，所以相当于当层的debt）
    但是，有更好的方法，就是在stack中额外存函数id，这样的话可以直接在pop后的函数中减掉。见
  https://leetcode.com/problems/exclusive-time-of-functions/discuss/105103/C%2B%2B-O(n)-stack-with-explaination
 */
class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        vector<int> result(n);
        vector<int> debt(1);
        stack<int> times;
        int level = 0;
        for (string &log : logs) {
            istringstream is(log);
            string token;
            getline(is, token, ':');
            int id = stoi(token);
            getline(is, token, ':');
            string type = token;
            getline(is, token, ':');
            int time = stoi(token);
            if (type == "start") {
                times.push(time); 
                if (++level >= debt.size()) {
                    debt.push_back(0);
                } else {
                    debt[level] = 0;
                }
            } else {
                int prev_time = times.top();
                times.pop();
                result[id] += time - prev_time + 1 - debt[level];
                debt[--level] += time - prev_time + 1;
            }
        }        
        return result;
    }
};

