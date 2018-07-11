/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * 快慢指针找当中，后半部分翻转，比较前半部分和翻转后的后半部分
 */
 class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        if (head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;        
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                if (fast != null) {
                    slow = slow.next;
                }
            }
        }
        ListNode halfStart = slow;
        ListNode h2 = slow.next;
        if (h2 != null) { 
            ListNode temp = h2.next;
            h2.next = null;
            h2 = temp; 
        }
        while (h2 != null) {
            ListNode temp = h2.next;
            h2.next = halfStart.next;
            halfStart.next = h2;
            h2 = temp;
        }
        h2 = halfStart.next;
        ListNode h1 = head;
        while (h2 != null) {
            if (h2.val != h1.val) { return false; }
            h1 = h1.next;
            h2 = h2.next;
        }
        return true;        
    }
}