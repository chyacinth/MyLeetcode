/*
// Definition for a QuadTree node.
class Node {
public:
    bool val;
    bool isLeaf;
    Node* topLeft;
    Node* topRight;
    Node* bottomLeft;
    Node* bottomRight;

    Node() {}

    Node(bool _val, bool _isLeaf, Node* _topLeft, Node* _topRight, Node* _bottomLeft, Node* _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
public:
  Node* dfs(const vector<vector<int>>& grid, int sx, int tx, int sy, int ty) {
    if (tx - sx == 1 && ty - sy == 1) {
      return new Node(grid[sx][sy] == 1, true, nullptr, nullptr, nullptr, nullptr);
    } else {
      int mx = (sx + tx) / 2;
      int my = (sy + ty) / 2;
      Node* result = new Node();
      result->isLeaf = false;
      result->val = 0;
      result->topLeft = dfs(grid, sx, mx, sy, my);
      result->topRight = dfs(grid, sx, mx, my, ty);
      result->bottomLeft = dfs(grid, mx, tx, sy, my);
      result->bottomRight = dfs(grid, mx, tx, my, ty);      
      if (result->topLeft && result->topRight && result->bottomLeft && result->bottomRight &&
          result->topLeft->isLeaf && result->topRight->isLeaf &&
          result->bottomLeft->isLeaf && result->bottomRight->isLeaf &&
          result->topLeft->val == result->topRight->val && 
          result->topRight->val == result->bottomLeft->val && 
          result->bottomLeft->val == result->bottomRight->val) {
        result->isLeaf = true;
        result->val = result->topLeft->val;
        if (result->topLeft) delete(result->topLeft);
        result->topLeft = nullptr;
        if (result->topRight) delete(result->topRight);
        result->topRight = nullptr;
        if (result->bottomLeft) delete(result->bottomLeft);
        result->bottomLeft = nullptr;
        if (result->bottomRight) delete(result->bottomRight);
        result->bottomRight = nullptr;
      }
      return result;
    }
    return nullptr;
  }
  Node* construct(vector<vector<int>>& grid) {
    int n = grid.size();
    if (n == 0) return nullptr;
    return dfs(grid, 0, n, 0, n);
  }
};