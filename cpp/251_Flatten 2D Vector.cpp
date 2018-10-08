class Vector2D {
public:
    Vector2D(vector<vector<int>>& vec2d) {
        first_dim_begin_iter_ = vec2d.begin();
        first_dim_end_iter_ = vec2d.end();        
        if (vec2d.size() > 0) {
            second_dim_begin_iter_ = vec2d[0].begin();
            second_dim_end_iter_ = vec2d[0].end();
        }
    }

    int next() {
        if (!hasNext()) return 0;
        
        if (second_dim_begin_iter_ != second_dim_end_iter_) {
            return *(second_dim_begin_iter_++);
        } else {
            ++first_dim_begin_iter_;
            while (first_dim_begin_iter_ != first_dim_end_iter_) {
                if (first_dim_begin_iter_->begin() != first_dim_begin_iter_->end()) {
                    break;
                }
                ++first_dim_begin_iter_;
            }
            second_dim_begin_iter_ = first_dim_begin_iter_->begin();
            second_dim_end_iter_ = first_dim_begin_iter_->end();
            return *(second_dim_begin_iter_++);
        }
    }

    bool hasNext() {
        if (second_dim_begin_iter_ != second_dim_end_iter_) return true;
        if (first_dim_begin_iter_ == first_dim_end_iter_) return false;
        auto temp_iter = first_dim_begin_iter_ + 1;
        while (temp_iter != first_dim_end_iter_) {
            if (temp_iter->begin() != temp_iter->end()) {
                return true;
            }
            ++temp_iter;
        }
        return false;
    }
    
private:
    vector<vector<int>>::iterator first_dim_begin_iter_;
    vector<vector<int>>::iterator first_dim_end_iter_;
    vector<int>::iterator second_dim_begin_iter_;
    vector<int>::iterator second_dim_end_iter_;
};

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i(vec2d);
 * while (i.hasNext()) cout << i.next();
 */