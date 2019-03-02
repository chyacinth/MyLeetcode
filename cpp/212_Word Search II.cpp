/**
 * Trie+回溯法+剪枝
 */ 
class Solution {
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        TrieNode *h = new TrieNode();
        for (string &w : words) {
            insert(h, w);
        }
        
        vector<string> res;
        int n = board.size();
        if (n == 0) return res;
        int m = board[0].size();
        if (m == 0) return res;
        
        vector<vector<int>> visited(n, vector<int>(m));
        int iter = 0;   
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                ++iter;
                if (auto tmp = h->children[board[i][j] - 'a']; tmp && visited[i][j] != iter) {
                    string str(1, board[i][j]);
                    visited[i][j] = iter;
                    dfs(board, i, j, n, m, visited, iter, str, res, tmp);
                }
            }
        }
        
        del(h);
        return res;
    }

private:
    
    int dx[4] = {0,-1,0,1};
    int dy[4] = {-1,0,1,0};
    

    struct TrieNode {
        TrieNode *children[26] = {};
        bool isEnd = false;
    };
    void insert(TrieNode *head, const string &s) {
        for (char c : s) {
            if (!head->children[c - 'a']) {
                head->children[c - 'a'] = new TrieNode();
            }
            head = head->children[c - 'a'];
        }
        head->isEnd = true;
    }
    bool search(TrieNode *head, const string &s) {
        for (char c : s) {
            if (!head->children[c - 'a']) {
                return false;
            }
            head = head->children[c - 'a'];
        }
        return head->isEnd;
    }
    void del(TrieNode *head) {
        for (auto node : head->children) {
            if (node) {
                del(node);
            }
        }
        delete head;
    }
    void dfs(vector<vector<char>>& board, int x, int y, int n, int m,
             vector<vector<int>> &visited, int iter, 
            string &str, vector<string> &res, TrieNode *h) {        
        if (h->isEnd) {
            res.push_back(str);
            h->isEnd = false;
        }
        for (int i = 0; i < 4; ++i) {
            if (int nx = x + dx[i], ny = y + dy[i]; nx >= 0 && nx <n && ny >= 0 && ny < m) {
                if (auto tmp = h->children[board[nx][ny] - 'a']; tmp && visited[nx][ny] != iter) {
                    str.push_back(board[nx][ny]);
                    visited[nx][ny] = iter;
                    dfs(board, nx, ny, n, m, visited, iter, str, res, tmp);
                    visited[nx][ny] = iter - 1;
                    str.pop_back();
                }
            }
        }
    }
};