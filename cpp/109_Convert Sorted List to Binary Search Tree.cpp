/**
 * 找到链表中点，然后取出中点，分开递归处理。细节方面，注意如果取出的中点就是起始点，需要特殊处理。
 */ 
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* cutHalf(ListNode *head) {
        ListNode *slow = head;
        ListNode *fast = head;
        ListNode *prev = nullptr;
        while (fast && fast->next && fast->next->next) {
            fast = fast->next->next;            
            prev = slow;
            slow = slow->next;            
        }
        if (prev) {
            prev->next = nullptr;
        }
        return slow;
    }
    TreeNode* sortedListToBST(ListNode* head) {
        if (!head) return nullptr;
        if (!head->next) {
            return new TreeNode(head->val);
        }
        ListNode* mid = cutHalf(head);        
        ListNode* second = mid->next;
        auto node = new TreeNode(mid->val);
        if (head != mid) {
            node->left = sortedListToBST(head);
        }
        node->right = sortedListToBST(second);
        return node;
    }
};