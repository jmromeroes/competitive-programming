/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    
    def deleteValues(head: ListNode): ListNode = {
        var referenceValue = head.x
        var curr = head
        
        while(curr != null && curr.x == referenceValue){
            curr = curr.next
        }
        
        curr
    }
    
    def deleteDuplicates(head: ListNode): ListNode = {
        if(head == null) return head
        
        var referenceHead: ListNode = null
        var currNode: ListNode = head
        var prev: ListNode = null
        
        while(currNode != null){
            if(referenceHead == null && currNode.next != null && currNode.x == currNode.next.x){
                currNode = deleteValues(currNode)
            } else if(currNode.next != null && currNode.x == currNode.next.x) {
                currNode = deleteValues(currNode)
                prev.next = currNode
            } else {
                if(referenceHead == null){
                    referenceHead = currNode
                    prev = referenceHead
                }
                prev = currNode
                if(currNode != null)
                    currNode = currNode.next
            }
        }
        
        referenceHead
    }
}
