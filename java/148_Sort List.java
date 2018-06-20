/*
链表+归并排序(merge sort)
不能用递归，因为递归的空间复杂度是O(n)
所以需要实现迭代版本的归并排序。
例：排序 7,6,5,4,3,2,1
第一次迭代 67,45,23,1
第二次迭代 4567,123
第三次迭代 1234567
共O(logN)次迭代，每次迭代耗时O(N)，总时间(ONlogN)
迭代时只需要记录各个指针就行了，非常繁琐
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
    
    int getLen(ListNode head) {
        int cnt = 0;
        while (head != null) {
            cnt += 1;
            head = head.next;
        }
        return cnt;
    }
    
    public ListNode sortList(ListNode head) {
            //dummy node
            ListNode h = new ListNode(0);
            h.next = head;
            ListNode l = null, r = null;
            ListNode prev, next;
            int leftCnt, rightCnt;

            int n = getLen(head);

            //iterate
            for (int groupSize = 2; groupSize / 2 <= n; groupSize *= 2) {
                //printList(h);
                int subLen = groupSize / 2;
                l = h.next;
                r = l;
                for (int i = 0; i < subLen; i++) {
                    if (r != null)
                        r = r.next;
                }
                next = r;
                for (int i = 0; i < subLen; i++) {
                    if (next != null)
                        next = next.next;
                }
                prev = h;
                leftCnt = 1;
                rightCnt = 1;
                ListNode p = prev;
                while (l != null) {
                    while (l != null && r != null) {
                        if (l.val < r.val) {
                            p.next = l;
                            p = p.next;
                            l = l.next;
                            leftCnt += 1;
                        } else {
                            p.next = r;
                            p = p.next;
                            r = r.next;
                            rightCnt += 1;
                        }
                        if (leftCnt > subLen) l = null;
                        if (rightCnt > subLen) r = null;
                    }
                    if (leftCnt <= subLen) {
                        while (l != null && leftCnt <= subLen) {
                            p.next = l;
                            p = p.next;
                            l = l.next;
                            leftCnt += 1;
                        }
                    }
                    if (rightCnt <= subLen) {
                        while (r != null && rightCnt <= subLen) {
                            p.next = r;
                            p = p.next;
                            r = r.next;
                            rightCnt += 1;
                        }
                    }
                    p.next = next;
                    l = next;
                    r = l;
                    for (int i = 0; i < subLen; i++) {
                        if (r != null)
                            r = r.next;
                    }
                    next = r;
                    for (int i = 0; i < subLen; i++) {
                        if (next != null)
                            next = next.next;
                    }
                    prev = p;
                    leftCnt = 1;
                    rightCnt = 1;
                }
            }
            return h.next;
        }
}