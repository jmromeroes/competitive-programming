/*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     data: Int
     *     next: SinglyLinkedListNode
     * }
     *
     */
    def insertNodeAtPosition(llist: SinglyLinkedListNode, data: Int, position: Int): SinglyLinkedListNode = {
        var node = new SinglyLinkedListNode(data)
        if(llist == null) return node
        var curr = llist
        var prev: SinglyLinkedListNode = null
        var currPos = 0
        while(curr != null){
            if(currPos == position){
                node.next = curr
                if(prev != null){
                    prev.next = node
                    return llist
                } else return node
            }
            prev = curr
            curr = curr.next
            currPos += 1
        }
        
        prev.next = node
        llist
    }
