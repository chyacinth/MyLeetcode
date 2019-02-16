/*
    使用map + list，使得既可以logn时间访问最大元素，又可以保证插入顺序
    见https://leetcode.com/problems/max-stack/discuss/108962/C%2B%2B-O(logN)-for-write-ops-O(1)-for-reads
*/
class MaxStack {
public:
    /** initialize your data structure here. */
    MaxStack() {
        
    }
    
    void push(int x) {
        li.push_back(x);
        mp[x].push_back(--li.end());
    }
    
    int pop() {
        int x = li.back();
        li.pop_back();
        mp[x].pop_back();
        if (mp[x].empty()) {
            mp.erase(x);
        }
        return x;
    }
    
    int top() {
        return li.back();
    }
    
    int peekMax() {
        return (--mp.end())->first;
    }
    
    int popMax() {
        auto max_iter = --mp.end(); // *{x, vec}
        int x = max_iter->first;
        li.erase(max_iter->second.back());
        mp[x].pop_back();
        if (mp[x].empty()) {
            mp.erase(x);
        }
        return x;
    }
private:
    list<int> li;
    map<int, vector<list<int>::iterator>> mp;
};

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */