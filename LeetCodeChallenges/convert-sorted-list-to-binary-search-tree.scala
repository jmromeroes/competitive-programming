/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def sortedListToBST(head: ListNode): TreeNode = {
        var n = 0
        var curr = head
        
        while(curr != null){
            n += 1
            curr = curr.next
        }
        
        var a = new Array[Int](n)
        
        curr = head
        
        for(i <- 0 until n){
            a(i) = curr.x
            curr = curr.next
        }
        
        def buildTree(leftBound: Int, rightBound: Int): TreeNode = {
            if(leftBound > rightBound) return null
            if(leftBound == rightBound) return TreeNode(a(leftBound))
            
            if(rightBound - leftBound == 1){
                if(a(rightBound) > a(leftBound)){
                    return TreeNode(a(rightBound), TreeNode(a(leftBound)), null)
                }
                
                return TreeNode(a(rightBound), null, TreeNode(a(leftBound)))
            }
            
            val middle = (leftBound + rightBound) / 2
            
            TreeNode(a(middle), buildTree(leftBound, middle - 1), buildTree(middle + 1, rightBound))
        }
        
        buildTree(0, n - 1)
    }
}
