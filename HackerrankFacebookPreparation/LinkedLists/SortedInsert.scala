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
    def sortedInsert(llist: DoublyLinkedListNode, data: Int): DoublyLinkedListNode = {
        var newNode = new DoublyLinkedListNode(data)
        
        var node = llist;
        var prev: DoublyLinkedListNode = null;

        if(node == null) return newNode
        
        while(node != null){
            if(data <= node.data){
                newNode.next = node;
                newNode.prev = prev;
                node.prev = newNode;
                if(prev != null) {
                    prev.next = newNode;
                    return llist;
                } else {
                    return newNode;
                }
            }
            prev = node;
            node = node.next;
        }

        newNode.next = null;
        newNode.prev = prev;
        prev.next = newNode;

        llist
    }
