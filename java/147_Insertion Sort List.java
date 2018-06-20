/*
对dummyNode的思考：
    为什么要dummyNode? 为了掌握所考察的节点的前一个节点。
    程序中实际指向的是prev节点，我们考察的则是prev.next节点，这样的话如果需要在考察节点前增加一个点，这可以很容易做到。
    如果最后发现不是在某个节点前，而是在链表最后加节点，则只需要判断prev=tail即可，代码要和上面情况分开写。
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
    public ListNode insertionSortList(ListNode head) {
        ListNode h = new ListNode(0), p, prev, t;
        h.next = head;
        prev = h;
        p = head;
        
        while (p != null) {
            t = h;
            while (t != prev) {
                if (t.next != null && t.next.val < p.val) {
                    t = t.next;
                }
                else break;
            }
            if (t == prev){
                prev = p;
                p = p.next;
            } else {
                prev.next = p.next;                
                p.next = t.next;
                t.next = p;
                p = prev.next;
            }            
        }
        return h.next;
    }
}