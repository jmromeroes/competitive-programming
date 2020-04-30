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
    public ListNode reverseList(ListNode head) {
        ListNode currPointer = head;
        ListNode reversedHead = null;
        ListNode nextNode = null;
        while(currPointer != null){
            nextNode = currPointer.next;
            currPointer.next = reversedHead;
            reversedHead = currPointer;
            currPointer = nextNode;
        }
        
        return reversedHead;
    }
}
