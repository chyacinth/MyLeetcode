/**
 * 多种解法，最简单的方法是遍历过的元素指向head作为标记（当然要实现判断这个元素本来不指向head，否则就是有cycle）
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode dh = new ListNode(0), p = head, tmp, prev;
        dh.next = head;
        prev = dh;
        while (p != null) {
            if (p == dh) return true;
            tmp = p.next;
            p.next = prev;
            prev = p;
            p = tmp;            
        }
        return false;
    }
}