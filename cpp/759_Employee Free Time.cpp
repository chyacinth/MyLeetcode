/**
 * 
 */ 
/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
  vector<Interval> employeeFreeTime(vector<vector<Interval>>& schedule) {
    vector<Interval> result;
    vector<int> indexes(schedule.size());
    if (schedule.size() == 0) { return result; }    
    bool empty = false;
    int left = -1;
    int right = -1;
    while (!empty) {
      int min_i = -1;
      for (int i = 0; i < indexes.size(); ++i) {
        int index = indexes[i];
        if (index < schedule[i].size() && 
            (min_i == -1 ||
             schedule[i][index].start < schedule[min_i][indexes[min_i]].start)) {
          min_i = i;
        }
      }
      if (min_i == -1) { 
        empty = true;
      } else {
        int start = schedule[min_i][indexes[min_i]].start;
        int end = schedule[min_i][indexes[min_i]].end;
        if (left == -1 && right == -1) {
          left = start;
          right = end;
        }        
        if (start <= right && end > right) {
          right = end;        
        } else if (start > right) {        
          result.push_back(Interval(right, start));
          left = start;
          right = end;        
        }
        ++indexes[min_i];
      }
    }
    return result;
  }
};