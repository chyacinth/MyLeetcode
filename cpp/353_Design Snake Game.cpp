/**
 * Use a deque to record the order of the snake.
 * Use a map to record the location of each part of the snake.
 * Also record the location of the current food.
 * When a snake moves, add to the front of the deque the new position
 * of the snake
 * */
class SnakeGame {
public:

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    SnakeGame(int width, int height, vector<pair<int, int>> food) :
    width_(width), height_(height), food_list_(food.begin(), food.end()) {
      snake_.emplace_back(0, 0);
      snake_map_.insert({0, 0});
      current_food_index_ = 0;
    }    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    int move(string direction) {        
        SnakeNode head = snake_[0];
        int x = head.x + delta[direction].first;
        int y = head.y + delta[direction].second;        
        snake_.emplace_front(x, y);
        
        head = snake_[0];
        if (head.x < 0 || head.x >= height_ || head.y < 0 || head.y >= width_) {
          return -1;
        }
        if (current_food_index_ >= food_list_.size() ||
            head.x != food_list_[current_food_index_].first ||
            head.y != food_list_[current_food_index_].second) {          
          snake_map_.erase(snake_map_.find({snake_.back().x,snake_.back().y}));
          snake_.pop_back();          
        } else {
          ++score_;
          ++current_food_index_;          
        }
      if (snake_map_.find({x, y}) != snake_map_.end()) {
          return -1;
        }
        snake_map_.insert({x, y});
      return score_;
    }

private:
    struct SnakeNode {
    public:
        SnakeNode(int ix, int iy) :
        x(ix), y(iy) {};
        int x = 0;
        int y = 0;                
    };
    
private:
    int width_;
    int height_;
    int score_ = 0;
    map<string, pair<int, int>> delta = {{"U",{-1,0}}, {"D",{1,0}}, {"L",{0,-1}}, {"R",{0,1}}};
    deque<pair<int, int>> food_list_;
    int current_food_index_ = 0;
    deque<SnakeNode> snake_;
    set<pair<int, int>> snake_map_;
};

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */