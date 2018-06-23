/**
 * 注意可以不用while，第一反应是用while，“假装”删除了节点，但实际上只要改一个节点，然后让他指向下下一个节点就行
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
    public void deleteNode(ListNode node) {        
        node.val = node.next.val;
        node.next = node.next.next;
        return;
    }
}