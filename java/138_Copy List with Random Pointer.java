/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node node = head;
        while (node != null) {
            Node newNode = new Node(node.val, node.next, null);
            node.next = newNode;
            node = newNode.next;
        }
        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        
        node = head;
        Node result = head.next;
        
        while (node != null) {
            Node nextNode = node.next.next;
            if (nextNode != null) {
                node.next.next = nextNode.next;
            } else {
                node.next.next = null;
            }
            node.next = nextNode;
            node = nextNode;
        }
        return result;
    }
}