/**
 * Partial sum, use sum[i][j] = matrix[0][0]+...+matrix[i][j]
 * sub_sum[i][j][k][l] = sum[k][l] - sum[i-1][l] - sum[k][j-1] + sum[i-1][k-1]
 */ 
class NumMatrix {
public:
    NumMatrix(vector<vector<int>> matrix) {
        n_ = matrix.size();
        if (n_ == 0) return;
        m_ = matrix[0].size();
        if (m_ == 0) return;
        partial_sum_ = vector<vector<int>>(n_, vector<int>(m_));
        for (int i = 0; i < n_; ++i)
            for (int j = 0; j < m_; ++j)                
                partial_sum_[i][j] += matrix[i][j] + 
                ((i - 1 >= 0)?partial_sum_[i - 1][j] : 0) + 
                ((j - 1 >= 0)?partial_sum_[i][j - 1] : 0) -
                ((i - 1 >= 0 && j - 1 >= 0)?partial_sum_[i - 1][j - 1] : 0);
    }
    
    int sumRegion(int row1, int col1, int row2, int col2) {
        return partial_sum_[row2][col2] - 
            ((row1 - 1 >= 0)?partial_sum_[row1 - 1][col2] : 0) - 
            ((col1 - 1 >= 0)?partial_sum_[row2][col1 - 1] : 0) +
            ((row1 - 1 >= 0 && col1 - 1 >= 0)?partial_sum_[row1 - 1][col1 - 1] : 0);
    }
    
private:
    vector<vector<int>> partial_sum_;
    int n_ = 0;
    int m_ = 0;
};

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */