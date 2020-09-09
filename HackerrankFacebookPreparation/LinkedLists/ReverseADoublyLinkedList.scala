/*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     data: Int
     *     next: DoublyLinkedListNode
     *     prev: DoublyLinkedListNode
     * }
     *
     */
    def reverse(llist: DoublyLinkedListNode): DoublyLinkedListNode = {
        var head: DoublyLinkedListNode = null
        var curr = llist
        while(curr.next != null){
            var next = curr.next
            curr.next = head
            curr.prev = next
            head = curr
            curr = next
        }

        curr.next = head
        curr
    }
