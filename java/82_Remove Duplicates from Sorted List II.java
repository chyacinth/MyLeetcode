/*
prev记录now前面一个元素。使用now指针作为探路，看看当前指向的元素有没有重复，如果有，则now一直前进到下一个不同的元素，让prev指向下一个（相当于删掉）
如果没有，则prev.next指向now,prev和now各向前那一步（代表记录下该元素）
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {return head;}
        ListNode prev = new ListNode(0), now = head, result = prev;
        boolean remove = false;
        prev.next = head;
        while (now.next != null) {
            remove = false;
            if (now.val == now.next.val) {remove = true;}
            while (now.next != null && now.val == now.next.val) {
                now = now.next;
            }
            if (remove) {
                prev.next = now.next;
                now = prev.next;
            }
            else {
                now = now.next;
                prev = prev.next;
            }            
            if (now == null) {break;}
        }
        return result.next;
    }
}