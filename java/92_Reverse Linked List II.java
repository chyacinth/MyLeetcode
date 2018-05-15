/*
颠倒链表的时候注意：迭代变量h在迭代链表的时候，在将h插到要颠倒的链表的头部之后，一定要将h指向颠倒链表的尾部!
不然下一次迭代h = h.next时，h会指向颠倒链表的第二项，而没有遍历链表!
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }
        int cnt = 0;
        boolean inverse = false;
        ListNode h = new ListNode(0), result = h, prev = h, endOfInv = null, prevOfInv = null;
        h.next = head;
        h = h.next;
        while (h != null) {            
            cnt += 1;
            if (cnt == m) {
                inverse = true;
                endOfInv = h;
                prevOfInv = prev;
                prev = null;
            }
            else if (inverse) {
                endOfInv.next = h.next;
                h.next = prevOfInv.next;
                prevOfInv.next = h;
                h = endOfInv;
                if (cnt == n) inverse = false;
            }
            h = h.next;
            if (prev != null)
                prev = prev.next;
        }
        return result.next;
    }
}