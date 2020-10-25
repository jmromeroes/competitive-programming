/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def partition(head: ListNode, x: Int): ListNode = {
        var refHead: ListNode = null
        var currNode = head
        var prev: ListNode = null
        
        //Find initial node for reference
        while(currNode != null && currNode.x < x){
            if(refHead == null){
                refHead = currNode
            }
            prev = currNode
            currNode = currNode.next
        }
        
        var refPrev: ListNode = currNode
        
        while(currNode != null){
            if(currNode.x < x){
                if(refHead == null){
                    refPrev.next = currNode.next
                    refHead = currNode
                    currNode.next = head
                    currNode = refPrev.next
                    prev = refHead
                } else {
                    refPrev.next = currNode.next
                    currNode.next = prev.next
                    prev.next = currNode
                    prev = currNode
                    currNode = refPrev.next
                }
            } else {
                refPrev = currNode
                currNode = currNode.next
            }
        }

        if(refHead == null) head else refHead
    }
}
