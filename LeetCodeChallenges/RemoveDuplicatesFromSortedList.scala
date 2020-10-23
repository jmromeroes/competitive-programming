/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def deleteDuplicates(head: ListNode): ListNode = {
        var currNode = head
        
        while(currNode != null){
            while(currNode.next != null && currNode.x == currNode.next.x){
                currNode.next = currNode.next.next
            }
            
            currNode = currNode.next
        }
        
        head
    }
}
