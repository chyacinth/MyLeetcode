/**
 * 
 **/ 
class Solution {
public:
    int findMinDifference(vector<string>& timePoints) {
      // vector< minute, original_index >
      vector<pair<int, int>> minutes(2 * timePoints.size());
      for (int i = 0; i < timePoints.size(); ++i) {        
        istringstream time(timePoints[i]);        
        string number;
        int minute = 0;        
        getline(time, number, ':');
        minute += stoi(number) * 60;
        getline(time, number, ':');
        minute += stoi(number);
        minutes[2 * i] = make_pair(minute, i);
        minutes[2 * i + 1] = make_pair(minute + 1440, i);        
      }
      sort(minutes.begin(), minutes.end());
      int result = 10'000;
      for (int i = 1; i < minutes.size(); ++i) {
        if (minutes[i - 1].second != minutes[i].second) {
          result = min(result, abs(minutes[i - 1].first - minutes[i].first));
        } else if (i - 2 >= 0) {
          result = min(result, abs(minutes[i - 2].first - minutes[i].first));
        }
      }
      return result;
    }
};