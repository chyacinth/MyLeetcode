/**
 * 可以不用dummy node
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
    public ListNode reverseList(ListNode head) {        
        ListNode result = head, temp;        
        while (head != null && head.next != null) {
            temp = head.next;
            head.next = temp.next;
            temp.next = result;
            result = temp;
        }
        return result;
    }
}