/**
 * Fast-Slow pointer
 */ 
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
  ListNode *detectCycle(ListNode *head) {
    if (head == NULL) {
      return NULL;
    }
    ListNode *slow = head;
    ListNode *fast = head;
    do {
      if (slow == NULL || fast == NULL) {
        return NULL;
      }
      slow = slow->next;      
      fast = fast->next;      
      if (fast == NULL) {
        return NULL;
      }
      fast = fast->next;
    } while (slow != fast);
    fast = head;
    while (slow != fast) {
      slow = slow->next;
      fast = fast->next;
    }
    return slow;
  }
};