/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Check if we have at least k nodes to reverse
        ListNode cursor = head;
        int count = 0;
        while (cursor != null && count < k) {
            cursor = cursor.next;
            count++;
        }
        
        // If there are less than k nodes, leave them as is
        if (count < k) {
            return head;
        }
        
        // Reverse the first k nodes
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        for (int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // head is now the tail of the reversed group; recursively process the remaining list
        head.next = reverseKGroup(curr, k);
        
        // prev is the new head of the reversed group
        return prev;
    }
}