/*
 Serialize: Use BFS to traverse the tree. Keep null if necessary
 Deserialize: Use BFS, but we need to keep TreeNode** so that we can change the TreeNode* the left/right pointer points to
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Codec {
public:
  
    
    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        string result = "[";
        queue<TreeNode*> q;
        q.push(root);
        while (!q.empty()) {
            TreeNode *node = q.front();
            q.pop();
            if (node) {
                q.push(node->left);
                q.push(node->right);
                result += to_string(node->val) + ",";                
            } else {
                result += "null,";
            }
        }
        result[result.size() - 1] = ']';
        return result;
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        istringstream is(data.substr(1, data.size() - 2));        
        string token;
        queue<TreeNode**> q;
        auto head = new TreeNode(0);
        q.push(&head);
        while (getline(is, token, ',')) {            
            TreeNode **node = q.front();
            q.pop();
            if (node) {
                if (token != "null") {
                    int num = stoi(token);
                    *node = new TreeNode(num);
                    q.push(&((*node)->left));
                    q.push(&((*node)->right));
                } else {
                    *node = nullptr;
                }                
            }            
            
        }
        return head;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.deserialize(codec.serialize(root));