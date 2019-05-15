/**
 * 简单递归
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {    
    public Node flattenHelper(Node head) {
        Node tail = head;
        Node childHead = head.child;
        Node childTail = null;
        Node nextHead = head.next;
        Node nextTail = null;
        if (childHead != null) {
            childTail = flattenHelper(childHead);
        }
        if (nextHead != null) {
            nextTail = flattenHelper(nextHead);
        }
        if (childHead != null) {
            tail.child = null;
            tail.next = childHead;
            childHead.prev = tail;
            tail = childTail;
        }
        if (nextHead != null) {
            tail.next = nextHead;
            nextHead.prev = tail;
            tail = nextTail;
        }
        return tail;
    }
    public Node flatten(Node head) {        
        if (head == null) {
            return null;
        }
        flattenHelper(head);        
        return head;
    }
}