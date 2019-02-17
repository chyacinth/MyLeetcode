/**
 * 前序+中序遍历。但是因为前序是排好序的，所以可以省去前序那部分，只要在中序序列中找比第一个数字大的那个，那个时候
 * 的就是右子树，那个之前的就是左子树。
 * 这是二叉搜索树的特性！！！
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
        if (!root) {
            return "";
        }
        string result;
        inOrderSearch(root, &result);
        result.pop_back();
        return result;
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        vector<int> in;
        stringstream ss(data);
        int temp;
        while (ss >> temp) {
            in.push_back(temp);
        }
        return buildTree(in, 0, in.size());
    }
private:
    void inOrderSearch(TreeNode *root, string *result) {                
        *result += to_string(root->val);
        *result += " ";
        if (root->left) {
            inOrderSearch(root->left, result);
        }
        if (root->right) {
            inOrderSearch(root->right, result);
        }
    }
    TreeNode *buildTree(const vector<int> &in, int l, int r) {        
        if (r <= l) return nullptr;        
        TreeNode *result = new TreeNode(in[l]);
        int i = l;
        for (; i < r; ++i) {
            if (in[i] > in[l]) break;
        }
        result->left = buildTree(in, l + 1, i);
        result->right = buildTree(in, i, r);
        return result;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.deserialize(codec.serialize(root));