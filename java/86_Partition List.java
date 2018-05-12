/*
lp指针指向<x的数组成链表
rp指针指向>=x的数组成链表
lp,rp的元素不需要新建，是需要指向源数组对应元素即可
注意rp最后元素的next要手动指向null，不然可能会无限循环
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
    public ListNode partition(ListNode head, int x) {
        if (head == null) {return head;}
        ListNode smallHead = new ListNode(0),largeHead = new ListNode(0), p = head, sp = smallHead, lp = largeHead;
        while (p != null) {
            if (p.val < x) {
                sp.next = p;
                sp  = sp.next;
            }
            else {
                lp.next = p;
                lp = lp.next;
            }
            p = p.next;
        }
        lp.next = null;
        sp.next = largeHead.next;
        return smallHead.next;
    }
}