/**
 * 1. 统计长度
 * 2. 计算加法
 * 3. 看到大于9，先拆成两部分，然后转置结果
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode resultHead = dummyNode.next;
        ListNode p = l1;
        int num1 = 0;
        while (p != null) {
            ++num1;
            p = p.next;
        }
        p = l2;
        int num2 = 0;
        while (p != null) {
            ++num2;
            p = p.next;
        }
        ListNode p1 = l1;
        ListNode p2 = l2;
        if (num1 > num2) {
            p1 = l1;
            for (int i = 0; i < num1 - num2; ++i) {
                dummyNode.next = new ListNode(p1.val);
                dummyNode.next.next = resultHead;
                resultHead = dummyNode.next;                
                p1 = p1.next;
            }
        } else if (num1 < num2) {
            p2 = l2;
            for (int i = 0; i < num2 - num1; ++i) {
                dummyNode.next = new ListNode(p2.val);
                dummyNode.next.next = resultHead;
                resultHead = dummyNode.next;                
                p2 = p2.next;
            }
        }        
        for (int i = 0; i < Math.min(num1, num2); ++i) {
            dummyNode.next = new ListNode(p1.val + p2.val);
            dummyNode.next.next = resultHead;
            resultHead = dummyNode.next;
            p1 = p1.next;
            p2 = p2.next;
        }        
        ListNode head = dummyNode.next;
        ListNode prev = dummyNode;
        int cnt = 0;
        while (head != null) {
            cnt += 1;
            if (head.val > 9 && head.next != null) {
                ++head.next.val;
                head.val -= 10;
            } else if (head.val > 9) {
                head.next = new ListNode(1);
                head.val -= 10;
            }
            if (cnt != 1) {
                ListNode nextNode = head.next;
                head.next = dummyNode.next;
                dummyNode.next = head;
                prev.next = nextNode;
                head = nextNode;
            } else {
                head = head.next;
                prev = prev.next;
            }            
        }
        return dummyNode.next;
    }
}