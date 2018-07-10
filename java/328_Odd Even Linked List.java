/**
 * 简单……一个指针维护odd，一个维护even，最后odd.next = evenhead即可
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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddEnd = head;
        if (oddEnd == null) return null;
        ListNode evenEnd = head.next;
        ListNode evenStart = evenEnd;
        if (evenEnd == null) return head;
        ListNode h = evenEnd.next;
        boolean isOdd = true;
        
        while (h != null) {
            if (isOdd) {
                ListNode temp = h.next;
                oddEnd.next = h;
                oddEnd = oddEnd.next;
                oddEnd.next = evenStart;
                h = temp;
                evenEnd.next = temp;
            } else {
                evenEnd.next = h;
                evenEnd = evenEnd.next;
                h = h.next;
            }
            isOdd = !isOdd;
        }
        
        return head;
    }
}