/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0, cnt = 0;
        ListNode p = head, endOfOld = null, tmp;                
        while (p != null) {
            len += 1;
            if (p.next == null) {endOfOld = p;}
            p = p.next;
        }
        if (len == 0) {return head;}
        k = k % len;                
        if (k == 0) {return head;}
        p = head;
        while (p != null) {
            cnt += 1;
            if (cnt == len - k) {                
                tmp = p.next;
                p.next = endOfOld.next;                
                endOfOld.next = head;
                head = tmp;
                break;
            }            
            p = p.next;
        }        
        return head;
    }
}