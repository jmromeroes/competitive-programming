/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode rootNode = null;
        ListNode currentNode = null;
        
        if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        }
        
        while(l1 != null && l2 != null){
            if(rootNode == null) {
                if(l1.val < l2.val) {
                   rootNode = new ListNode(l1.val);
                   l1 = l1.next;
                } else {
                   rootNode = new ListNode(l2.val);
                   l2 = l2.next; 
                }
                currentNode = rootNode;
            } else {
                if(l1.val > l2.val) {
                   currentNode.next = new ListNode(l2.val);
                   currentNode = currentNode.next;
                   l2 = l2.next;
                } else {
                   currentNode.next = new ListNode(l1.val);
                   currentNode = currentNode.next;
                   l1 = l1.next; 
                }
            }
        }
        
        if(l1 != null) {
            currentNode.next = l1;
        } else {
            currentNode.next = l2;
        }
        
        return rootNode;
    }
}
