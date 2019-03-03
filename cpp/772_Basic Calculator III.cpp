/**
 * 难题。最好的解法是中缀表达式转后缀表达式。
 * 解法见：https://blog.csdn.net/daheiantian/article/details/6553713 讲得很好
 * std::variant 很好用！注意可以靠index()来判断类型
 */ 
class Solution {
public:    
    int calculate(string s) {
        s = "("s + s + ")"s;
        stack<char> ops;
        queue<std::variant<long, char>> post;
        bool is_forming_digit = false;
        long temp = 0;
        for (char ch : s) {
            if (isdigit(ch)) {
                is_forming_digit = true;
                temp = temp * 10 + (ch - '0');
            } else if (ch != ' ') {
                if (is_forming_digit) {
                    post.push(temp);
                    is_forming_digit = false;
                    temp = 0;                
                }
                if (ch == '(') {
                    ops.push(ch);
                } else if (ch == ')') {
                    while (ops.top() != '(') {
                        post.push(ops.top());
                        ops.pop();
                    }
                    ops.pop();
                } else {
                    while (compare(ch, ops.top()) <= 0) {
                        post.push(ops.top());
                        ops.pop();
                    }
                    ops.push(ch);
                }
            }
        }
        stack<long> result;
        while (!post.empty()) {            
            auto v = post.front();
            switch (v.index()) {
                // v is long
                case 0 : result.push(get<long>(v));                                        
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
        return result.top();
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