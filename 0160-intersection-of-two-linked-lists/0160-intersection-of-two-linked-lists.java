/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Base case: if either list is empty, there can't be an intersection
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        
        // Loop until both pointers meet at the intersection node or both become null
        while (pointerA != pointerB) {
            // Move pointerA to the next node, or switch to headB if it hits the end
            pointerA = (pointerA != null) ? pointerA.next : headB;
            
            // Move pointerB to the next node, or switch to headA if it hits the end
            pointerB = (pointerB != null) ? pointerB.next : headA;
        }
        
        return pointerA; // Returns the intersection node, or null if they don't intersect
    }
}