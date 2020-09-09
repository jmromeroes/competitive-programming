/*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        Set<SinglyLinkedListNode> nodes = new HashSet();

        while(head1 != null){
            nodes.add(head1);
            head1 = head1.next;
        }

        while(head2 != null){
            if(nodes.contains(head2)){
                return head2.data;
            }
            head2 = head2.next;
        }

        return 0;
    }
