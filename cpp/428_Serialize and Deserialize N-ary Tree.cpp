/*
// Definition for a Node.
class Node {
public:
    int val = 0;
    vector<Node*> children;

    Node() {}

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {
public:

  // Encodes a tree to a single string.
  string serialize(Node* root) {    
    string result;
    if (!root) {
      return result;
    }
    result += to_string(root->val) + " " + to_string(root->children.size()) + " "s;
    for (int i = 0; i < root->children.size(); ++i) {
      result += serialize(root->children[i]);
      if (i < root->children.size() - 1) {
        result += " ";
      }
    }       
    return result;
  }

  Node* dfs(istringstream& is) {
    string number;
    Node* node = nullptr;    
    if (is >> number) {      
      node = new Node;
      node->val = stoi(number);
      string n;
      is >> n;
      for (int i = 0; i < stoi(n); ++i) {
        node->children.push_back(dfs(is));
      }      
    }
    return node;
  }
  // Decodes your encoded data to tree.
  Node* deserialize(string data) {
    if (data.empty()) {
      return nullptr;
    }
    istringstream is(data);
    return dfs(is);
  }
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.deserialize(codec.serialize(root));