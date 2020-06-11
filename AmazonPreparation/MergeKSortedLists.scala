import scala.collection.mutable.PriorityQueue

/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    
    def mergeKLists(lists: Array[ListNode]): ListNode = {
        val priorityQueue: PriorityQueue[ListNode] = PriorityQueue()(
            Ordering.by((_: ListNode).x).reverse
        )
        
        for(l <- lists){
            var lt: ListNode = l
            while(lt != null){
                priorityQueue += lt
                lt = lt.next
            }
        }
        
        if(!priorityQueue.isEmpty){
            val root: ListNode = priorityQueue.dequeue()
            var node: ListNode = root

            while(!priorityQueue.isEmpty){
                node.next = priorityQueue.dequeue()
                node = node.next
                node.next = null
            }
            return root
        }
        
        null
    }
}