/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode resultList = null;
        ListNode resultListPointer = null;
        
        boolean allPointersNull = false;
        
        while(!allPointersNull) {
            int minNodeIndex = -1;
            for(int i=0; i<lists.length; i++){
                ListNode currentNode = lists[i];
                if(currentNode != null) {
                    if(minNodeIndex == -1 || currentNode.val < lists[minNodeIndex].val) {
                        minNodeIndex = i;
                    }
                }
            }
            
            if(minNodeIndex == -1) {
                allPointersNull=true;
            } else {
                if(resultList == null){
                    resultList = lists[minNodeIndex];
                    lists[minNodeIndex] = lists[minNodeIndex].next;
                    resultListPointer = resultList;
                } else {
                    resultListPointer.next = lists[minNodeIndex];
                    lists[minNodeIndex] = lists[minNodeIndex].next;
                    resultListPointer = resultListPointer.next;
                }
                resultListPointer.next = null;
            }
        }
        
        return resultList;
    }
}
