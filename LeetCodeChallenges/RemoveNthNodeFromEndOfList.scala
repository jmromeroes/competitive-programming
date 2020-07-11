/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
        if(head == null) return null
        def removeNthRecursion(node: ListNode): (Int, ListNode) = {
            if(node.next == null) (1, if(n == 1) null else node) 
            else {
                val nextReference = removeNthRecursion(node.next)
                val depth = nextReference._1 + 1
                val nextNode = nextReference._2
                
                if(depth == n)
                    (depth, nextNode)
                else 
                    (depth, new ListNode(node.x, nextNode))
            }
        }
        
        removeNthRecursion(head)._2
    }
}