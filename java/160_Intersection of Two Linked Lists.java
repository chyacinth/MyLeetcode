/**
 * 先两边同时向前遍历，根据到达终点的先后步差决定两个链表长度差。然后根据让长的那个从头先走该步差步，这样两个链表的长度相同
 * 只要同时向前遍历，找到第一个相同的节点即可
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) { return null; }
        int cnt = 0;        
        ListNode hA = headA;
        ListNode hB = headB;
        boolean startB = false;
        while (hA.next != null || hB.next != null) {
            if (hA.next != null) {
                hA = hA.next;
            } else { 
                startB = true;
                cnt += 1; 
            }
            if (hB.next != null) {
                hB = hB.next;
            } else { cnt += 1; }            
        }
        if (hA != hB) { return null; }
        hA = headA;
        hB = headB;
        if (startB) {
            for (int i = 0; i < cnt; ++i) {
                hB = hB.next;
            }            
        }
        else {
            for (int i = 0; i < cnt; ++i) {
                hA = hA.next;
            }            
        }
        while (hA != null && hB != null) {
            if (hA == hB) { return hA; }
            hA = hA.next;
            hB = hB.next;
        }
        return hA;
    }
}