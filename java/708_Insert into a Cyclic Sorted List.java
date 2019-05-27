/**
 * 没啥好说的，主要考虑一下全是一样的数字，插入一个不一样数字的情况。此时需要判断是不是转完一圈(head = result)，如果转完一圈，说明是这个情况，加即可。
 */
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
        if (head == null) {
            return new Node(insertVal, null);
        }
        Node result = head;        
        while (true) {
            if ((head.val <= insertVal && insertVal <= head.next.val) || 
               (head.val <= insertVal && head.val > head.next.val) || 
               (head.next.val >= insertVal && head.val > head.next.val)) {
                head.next = new Node(insertVal, head.next);
                break;
            }
            head = head.next;
            if (head == result) {
                head.next = new Node(insertVal, head.next);
                break;
            }
        }
        return result;
    }
}