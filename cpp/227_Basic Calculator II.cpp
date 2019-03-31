/**
 * 难题。最好的解法是中缀表达式转后缀表达式。
 * 解法见：https://blog.csdn.net/daheiantian/article/details/6553713 讲得很好
 * std::variant 很好用！注意可以靠index()来判断类型
 * 新进来的运算符都是不放入post的，都是放入ops
 */ 
class Solution {
public:
    int calculate(string s) {
        stack<char> ops;
        queue<variant<long, char>> post;
        long temp = 0;
        bool forming_digit = false;
        s = "("s + s + ")"s;
        for (char c : s) {            
            if (c == ' ') { continue; }
            if (isdigit(c)) {
                forming_digit = true;
                temp = 10 * temp + (c - '0');
            } else {
                if (forming_digit) {
                    post.push(temp);
                    temp = 0;
                    forming_digit = false;                    
                }
                if (c == '(') {
                    ops.push(c);
                } else if (c == ')') {
                    while (ops.top() != '(') {
                        post.push(ops.top());
                        ops.pop();
                    }
                    ops.pop();
                } else {                    
                    while (compare(ops.top(), c) >=0) {
                        post.push(ops.top());
                        ops.pop();
                    }
                    ops.push(c);
                }
            }
        }        
        stack<long> result;
        while (!post.empty()) {
            auto v = post.front();
            switch (v.index()) {
                // v is long
                case 0 : 
                    result.push(get<long>(v));
                    break;
                // v is char
                case 1 :                    
                    long num2 = result.top();
                    result.pop();
                    long num1 = result.top();
                    result.pop();
                    result.push(calc(num1, num2, get<char>(v)));                    
                    break;
            }
            post.pop();
        }
        if (result.empty()) {
            return 0;
        }
        return static_cast<int>(result.top());
    }
    long calc(long n1, long n2, char ops) {
        switch (ops) {
            case '+' : return n1 + n2;
            case '-' : return n1 - n2;
            case '*' : return n1 * n2;
            case '/' : return n1 / n2;
        }
        return 0;
    }
    
    int compare(const char a, const char b) {
        return priority[a] - priority[b];
    }
private:
    unordered_map<char, int> priority = {{'(', 0}, {'+', 1}, {'-',1}, {'*', 2}, {'/', 2}};
};