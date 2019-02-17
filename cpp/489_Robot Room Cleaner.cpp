/**
 * 
 */ 
/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * class Robot {
 *   public:
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     bool move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     void turnLeft();
 *     void turnRight();
 *
 *     // Clean the current cell.
 *     void clean();
 * };
 */
class Solution {
public:
    void helper(Robot& robot, int x, int y, int dir) {        
        string key = std::to_string(x) + " " + std::to_string(y);
        if (visited.find(key) != visited.end()) {
            return;   
        }
        visited.insert(key);
        
        robot.clean();
        
        for (int i = 0; i < 4; ++i) {            
            int t = (dir + i) % 4;
            if (robot.move()) {
                helper(robot, x + dx[t], y + dy[t], t);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnLeft();
            } else {
                robot.turnRight();
            }
            
        }
    }
    void cleanRoom(Robot& robot) {
        helper(robot, 0, 0, 0);
    }
private:
    int dx[4] = {0,1,0,-1};
    int dy[4] = {1,0,-1,0};
    unordered_set<string> visited;
};