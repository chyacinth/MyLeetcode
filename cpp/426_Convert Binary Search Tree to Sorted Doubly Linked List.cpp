/*
    Simple recursion
*/
/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;

    Node() {}

    Node(int _val, Node* _left, Node* _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
public:
    std::pair<Node*, Node*> helper(Node* root) {
        if (root == nullptr) return {nullptr, nullptr};
        Node *head = root;
        auto lh = helper(root->left);
        auto rh = helper(root->right);
        Node *ans_l = root, *ans_r = root;
        if (lh.second) {
            lh.second->right = root;
            root->left = lh.second;
            ans_l = lh.first;
        }
        if (rh.first) {
            root->right = rh.first;
            rh.first->left = root;
            ans_r = rh.second;
        }
        return {ans_l, ans_r};
    }
    Node* treeToDoublyList(Node* root) {
        auto [lnode, rnode] = helper(root);
        if (lnode)
            lnode->left = rnode;
        if (rnode)
            rnode->right = lnode;
        return lnode;
    }
};