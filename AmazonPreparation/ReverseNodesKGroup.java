/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseGroup(ListNode head, int k) {
        ListNode revHead = null;
        ListNode currPointer = head;
        
        for(int i=0; i<k; i++) {
            // First move head forward so we can reference it later (It will end up in the end of the list)
            head = currPointer.next;
            
            // Change next value of currPointer to the revHead so we reverse the list
            currPointer.next = revHead;
            
            // Assign the revHead to the currPointer for next iteration
            revHead = currPointer;
            
            // To start over again
            currPointer = head;
        }
        return revHead;
    }
    
    public ListNode getNodeInK(ListNode head, int k) {
        ListNode currPointer = head;
        for(int i=1; i<k; i++){
            if(currPointer == null) {
                return null;
            } else {
                currPointer = currPointer.next;
            }
        }  
        
        return currPointer;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(k <= 1) {
            return head;
        }
        
        // Will be just the answer
        ListNode reversedHead = null;
        
        ListNode newHead = null;
        ListNode currentPointer = head;
        ListNode referenceNode = getNodeInK(currentPointer, k);
        ListNode nextHead = referenceNode.next;
        ListNode tail = null;
        
        if(referenceNode != null) {
            reversedHead = reverseGroup(currentPointer, k);
            tail = currentPointer;
            tail.next = reversedHead;
            newHead = reversedHead;
            currentPointer = nextHead;
        } else {
            return head;
        }
        
        while(referenceNode != null && referenceNode.next != null) {
            referenceNode = getNodeInK(currentPointer, k);
            if(referenceNode != null) {
                nextHead = referenceNode.next;
                newHead = reverseGroup(currentPointer, k);
                tail.next = newHead;
                tail=currentPointer;
                currentPointer=nextHead;
            } else {
                tail.next = currentPointer;
                break;
            }
            
        }
        
        return reversedHead;
    }
}
