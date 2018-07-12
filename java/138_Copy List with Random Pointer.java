/**
 * 两种方法：
 * 1. 简单方法：用一个HashMap，记录结果链表和原链表的对应关系，这样就能知道Node.random的对应情况
 * 2. 牛逼方法：原链表的每个节点后面加一个节点，然后新加的节点的random为前面原来节点的random的后面一个这样就有两个相同的list
 * 交错在一起，然后只要取出链表中的2、4、6...个就行了
 */
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode h = head;
        RandomListNode temp;
        while (h != null) {            
            temp = new RandomListNode(h.label);
            temp.next = h.next;
            h.next = temp;
            h = temp.next;
        }
        RandomListNode prev = head;
        h = head.next;
        while (prev != null) {
            if (prev.random == null) { h.random = null; }
            else { h.random = prev.random.next; }            
            prev = prev.next.next;
            if (prev != null) { h = h.next.next; }            
        }
        RandomListNode result = head.next;
        h = head;
        while (h.next != null) {
            temp = h.next;            
            h.next = h.next.next;
            h = temp;
        }
        return result;
    }
}