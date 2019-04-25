/**
 * 难题，而且意义不大，没什么可迁移性。我们仍然希望能求出每个点的水位高度。基于水的性质，我们
 * 从最外面一圈开始围墙，找到最小值，把最小值里侧的点填满。此时由于水流的性质，最小值里面点填的值就是
 * 这个位置最终的值。然后把最小值里侧的点作为新的墙加入。具体见https://www.youtube.com/watch?v=cJayBq38VYw
 **/ 
class Solution {
public:
  int trapRainWater(vector<vector<int>>& heightMap) {
    if (heightMap.size() == 0) {
      return 0;
    }
    using Point = pair<int, int>;
    using Pq_node = pair<int, Point>;
    
    auto cmp = [](const Pq_node& l, const Pq_node& r) { return l.first > r.first; };
    int n = heightMap.size();
    int m = heightMap[0].size();
    vector<vector<char>> visited(n, vector<char>(m));
    
    priority_queue<Pq_node, vector<Pq_node>, decltype(cmp)> pq(cmp);
    for (int i = 0; i < n; ++i) {      
      for (int j = 0; j < m; ++j) {
        if (i == 0 || i == n - 1) {
          pq.push({heightMap[i][j], {i, j}});
          visited[i][j] = true;
        } else if (j == 0 || j == m - 1){
          pq.push({heightMap[i][j], {i, j}});
          visited[i][j] = true;
        }
      }
    }
    int max_height = -1;
    int result = 0;
    while (!pq.empty()) {
      auto top_node = pq.top();
      auto point = top_node.second;
      //cout << "top node: " << top_node.first << " " << point.first << " " << point.second << endl;
      pq.pop();
      max_height = max(max_height, top_node.first);      
      for (int i = 0; i < 4; ++i) {
        int tx = point.first + dx[i];
        int ty = point.second + dy[i];        
        if (tx >= 0 && tx < n && ty >= 0 && ty < m && !visited[tx][ty]) {          
          visited[tx][ty] = 1;
          result += max(0, max_height - heightMap[tx][ty]);                    
          pq.push({heightMap[tx][ty], {tx, ty}});
          //cout << "push node " << heightMap[tx][ty] << " " << tx << " " << ty << endl;
        }        
      }      
    }
    return result;
  }
private:
  array<int, 4> dx{0, -1, 0, 1};
  array<int, 4> dy{-1, 0, 1, 0};
};