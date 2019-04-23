class Solution {
public:
  int candy(vector<int>& ratings) {
    int n = ratings.size();
    vector<int> left_min(n);
    vector<int> right_min(n);    
    for (int i = 0; i < n; ++i) {
      bool seq_left = true;
      bool seq_right = true;      
      if (i > 0 && ratings[i - 1] < ratings[i]) {
        seq_left = false;
      }
      if (i < n - 1 && ratings[i + 1] < ratings[i]) {
        seq_right = false;
      }
      if (seq_left && seq_right) {
        left_min[i] = i;
      } else {
        if (i > 0) {
          left_min[i] = left_min[i - 1];
        } else {
          left_min[i] = 0;
        }
      }
    }
    for (int i = n - 1; i >= 0; --i) {
      bool seq_left = true;
      bool seq_right = true;
      if (i > 0 && ratings[i - 1] < ratings[i]) {
        seq_left = false;
      }
      if (i < n - 1 && ratings[i + 1] < ratings[i]) {
        seq_right = false;
      }
      if (seq_left && seq_right) {
        right_min[i] = i;
      } else {
        if (i < n - 1) {
          right_min[i] = right_min[i + 1];
        } else {
          right_min[i] = n - 1;
        }
      }
    }
    int result = 0;
    /*for (int x : left_min) cout << x << " ";
    cout << endl;
    for (int x : right_min) cout << x << " ";
    cout << endl;*/
    for (int i = 0; i < n; ++i) {
      int t = 1;
      if (i > 0 && ratings[i - 1] < ratings[i]) {
        t = max(t, i - left_min[i] + 1);
      }
      if (i < n - 1 && ratings[i + 1] < ratings[i]) {
        t = max(t, right_min[i] - i + 1);
      }
      cout << t << " ";
      result += t;
    }
    return result;
  }
};