/**
 * clone the neighbors with recursion
 */ 
/**
 * Definition for undirected graph.
 * struct UndirectedGraphNode {
 *     int label;
 *     vector<UndirectedGraphNode *> neighbors;
 *     UndirectedGraphNode(int x) : label(x) {};
 * };
 */
class Solution {
public:
  UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
    if (node == NULL) {
      return NULL;
    }
    if (label_node_map_[node->label] != NULL) {return label_node_map_[node->label];}
    UndirectedGraphNode *newNode = new UndirectedGraphNode(node->label);
    label_node_map_[node->label] = newNode;
    for (auto&& neighbor : node->neighbors) {
      newNode->neighbors.push_back(cloneGraph(neighbor));
    }
    return newNode;
  }
private:
  unordered_map<int, UndirectedGraphNode*> label_node_map_;
};

