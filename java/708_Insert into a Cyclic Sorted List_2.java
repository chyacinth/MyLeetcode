/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
  public Node insert(Node head, int insertVal) {
    if (head == null) { return new Node(insertVal, null); }
    if (head.next == null) {
      head.next = new Node(insertVal, null);
    } else {
      Node p = head;
      while (true) {
        if ((p.val <= insertVal && insertVal <= p.next.val) || (p.val > p.next.val && (p.val <= insertVal || insertVal <= p.next.val))) {
          p.next = new Node(insertVal, p.next);
          break;
        } else {
          if (p.val == p.next.val && p.next == head) {
            p.next = new Node(insertVal, p.next);
            break;
          }
        }
        p = p.next;
      }
    }
    return head;
  }
}