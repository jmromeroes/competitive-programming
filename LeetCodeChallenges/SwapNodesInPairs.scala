/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def swapPairs(head: ListNode): ListNode = {
        if(head == null) return head
        else if(head.next == null) return head
        
        val tmp = head.next
        head.next = tmp.next
        tmp.next = head
        
        head.next = swapPairs(head.next)
        tmp
    }
}