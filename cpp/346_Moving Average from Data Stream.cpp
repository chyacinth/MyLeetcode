class MovingAverage {
public:
  /** Initialize your data structure here. */
  MovingAverage(int size) {
    size_ = size;    
    sum_ = 0;
  }
    
  double next(int val) {
    sum_ += val;
    if (nums_.size() == size_) {
      sum_ -= nums_.front();
      nums_.pop();
    }
    nums_.push(val);
    return (static_cast<double>(sum_) / nums_.size());
  }
private:
  queue<int> nums_;
  int size_;
  int sum_;
};

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */