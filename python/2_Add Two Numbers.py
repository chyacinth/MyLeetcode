# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
import re

class Solution:
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        p1 = l1
        p2 = l2
        head3 = ListNode(0)
        node = head3
        residual = 0
        while True:
            p1x, p2x = 0, 0
            if p1 != None:
                p1x = p1.val
            if p2 != None:
                p2x = p2.val              
            node.val = p1x + p2x + residual
            residual = 0
            node.val, residual = node.val % 10, node.val // 10
            if ((p1 == None or p1.next == None) and (p2 == None or p2.next == None) and residual == 0):
                break
            if p1 != None:
                p1 = p1.next
            if p2 != None:
                p2 = p2.next
            node.next = ListNode(0)
            node = node.next
        
        return head3