/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    private Node copyFullList(Node head) {
        
        HashMap<Node, Integer> nodeMap = new HashMap<>();
        HashMap<Integer, Node> referenceMap = new HashMap<>();
        HashMap<Integer, Integer> indexesMap = new HashMap<>();
        
        Node newHead = new Node(head.val);
        Node currNode = newHead;
        Node referenceHead = head;
        int index=0;
        while(referenceHead != null){
            nodeMap.put(referenceHead, index);
            referenceMap.put(index, currNode);
            
            referenceHead = referenceHead.next;
        currNode.next = referenceHead!=null?new Node(referenceHead.val):null;
            currNode = currNode.next;
            index++;
        }
        
        currNode = newHead;
        referenceHead = head;
        index=0;
        while(referenceHead != null){
            indexesMap.put(index, nodeMap.get(referenceHead.random));
            referenceHead = referenceHead.next;
            index++;
        }
        
        currNode = newHead;
        referenceHead = head;
        index=0;
        while(referenceHead != null){
            currNode.random = referenceMap.get(indexesMap.get(index));
            referenceHead = referenceHead.next;
            currNode = currNode.next;
            index++;
        }
        
        return newHead;
    }
    
    public Node copyRandomList(Node head) {
        
        if(head == null){
            return null;
        }
        
        Node newList = copyFullList(head);
        
        return newList;
    }
}
