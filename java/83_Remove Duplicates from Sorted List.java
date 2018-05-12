/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {return head;}
        ListNode prev = new ListNode(0), now = head, result = prev;
        prev.next = head;
        while (now.next != null) {
            while (now.next != null && now.next.val == now.val) {
                now = now.next;
            }
            prev.next = now;
            prev = prev.next;
            now = now.next;
            if (now == null) {break;}
        }
        return result.next;
    }
}