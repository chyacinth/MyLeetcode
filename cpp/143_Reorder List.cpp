/**
 * split, reverse, merge 
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
    ListNode *findMiddleNode(ListNode *head) {
        ListNode *fast = head, *slow = head;
        do {            
            if (slow->next) { 
                slow = slow->next; 
            } else {
                break;
            }
            if (slow->next) { 
                slow = slow->next; 
            } else {
                break;
            }
            fast = fast->next;
        } while (slow);
        return fast;
            
    }
    void reverseList(ListNode* head) {
        ListNode* start = head->next;
        if (start->next == nullptr) {
            return;
        }
        ListNode* prev = start;
        start = start->next;
        while (start) {
            prev->next = start->next;
            start->next = head->next;
            head->next = start;
            start = prev->next;
        }
    }
    void interleaveList(ListNode *first, ListNode *second) {
        while (second) {
            auto next_first = first->next;
            auto next_second = second->next;            
            first->next = second;
            second->next = next_first;
            first = next_first;
            second = next_second;
        }
    }
    void reorderList(ListNode* head) {
        if (!head || !head->next) {
            return;
        }
        //find middle node
        auto mid_node = findMiddleNode(head);
        //reverse second half
        reverseList(mid_node);        
        //interleave list        
        ListNode* first = head;
        ListNode* second = mid_node->next;
        mid_node->next = nullptr;
        interleaveList(first, second);
      
    }
};