/**
 * 难题?
 **/ 
class NumMatrix {
public:
    NumMatrix(vector<vector<int>>& matrix): 
        sum(matrix.size(), vector<int>(matrix.size() > 0? matrix[0].size() : 0)),
        n(matrix.size()), m(matrix.size() > 0? matrix[0].size() : 0) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (j == 0) { sum[i][j] = matrix[i][j]; }
                else { sum[i][j] = matrix[i][j] + sum[i][j - 1]; }
            }
        }
    }
    
    void update(int row, int col, int val) {
        int delta = val - (col > 0? sum[row][col] - sum[row][col - 1] : sum[row][col]);        
        for (int j = col; j < m; ++j) {
            sum[row][j] += delta;
        }
    }
    
    int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for (int i = row1; i <= row2; ++i) {
            result += (col1 > 0? sum[i][col2] - sum[i][col1 - 1] : sum[i][col2]);
        }
        return result;
    }
private:
    vector<vector<int>> sum;
    int n = 0;
    int m = 0;
};

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix* obj = new NumMatrix(matrix);
 * obj->update(row,col,val);
 * int param_2 = obj->sumRegion(row1,col1,row2,col2);
 */