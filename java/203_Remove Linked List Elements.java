/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode p = head;
        ListNode prev = dummyNode;
        while (p != null) {            
            if (p.val == val) {
                prev.next = p.next;
                p = p.next;                
            }
            else {
                p = p.next;
                prev = prev.next;
            }
        }
        return dummyNode.next;
    }
}