/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {

    def invertList(head: ListNode): ListNode = {
        var newHead: ListNode = null
        var curr = head
        var ptr = head
        while(curr != null){
            ptr = ptr.next
            curr.next = newHead
            newHead = curr
            curr = ptr
        }
        
        newHead
    }
    
    def lookForK(head: ListNode, k: Int): ListNode = {
        var j: Int = k
        var curr: ListNode = head
        
        while(j > 0){
            if(curr == null){
                curr = head
            }
            
            curr = curr.next
            
            j -= 1
        }
        
        if(curr == null) head else curr
    }
    
    def connect(head1: ListNode, head2: ListNode): ListNode = {
        if(head1 == head2) return head1
        var curr = head1
        
        while(curr.next != null) {
            curr = curr.next
        } 
        
        curr.next = head2
        
        head1
    }
    
    def rotateRight(head: ListNode, k: Int): ListNode = {
        if(k == 0 || head == null) return head
        
        val invertedList = invertList(head)
        val prevNode = lookForK(invertedList, k)
        val identity = invertList(invertedList)
        
        val newHead = if(prevNode.next != null) prevNode.next else head
        prevNode.next = null
        
        connect(newHead, head)
    }
}
