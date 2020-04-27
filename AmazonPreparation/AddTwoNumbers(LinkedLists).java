import java.math.BigInteger;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private ListNode fromStringToList(String str) {
        ListNode currentNode = null;
        ListNode rootNode = null;
        
        for(int i = str.length() - 1; i >= 0; i--) {
            int v = Character.getNumericValue(str.charAt(i));
            
            if(rootNode == null) {
                rootNode = new ListNode(v);
                currentNode = rootNode;
            } else {
                currentNode.next = new ListNode(v);
                currentNode = currentNode.next;
            }
        } 
        
        return rootNode;
    }
    
    private BigInteger getNumberFromList(ListNode l) {
        int level = 0;
        BigInteger res = BigInteger.ZERO;
        while(l != null) {
            BigInteger currentNumber = new BigInteger(Integer.toString(l.val));
            res = res.add(currentNumber.multiply(BigInteger.TEN.pow(level)));
            l = l.next;
            level++;
        }
        
        return res;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        BigInteger v1 = getNumberFromList(l1);
        BigInteger v2 = getNumberFromList(l2);
        
        BigInteger sum = v1.add(v2);

        return fromStringToList(sum.toString());
    }
    
}
