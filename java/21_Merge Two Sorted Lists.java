/**
 * 归并排序
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0), result = h;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val){ 
                h.next = new ListNode(l1.val);
                h = h.next;
                l1 = l1.next;
            }
            else {
                h.next = new ListNode(l2.val);
                h = h.next;
                l2 = l2.next;
            }            
        }
        while (l1 != null) {
            h.next = new ListNode(l1.val);
            h = h.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            h.next = new ListNode(l2.val);
            h = h.next;
            l2 = l2.next;
        }
        return result.next;
    }
}