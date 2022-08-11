/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def isBalanced(root: TreeNode): Boolean = {
        
        def getMaxHeights(curr: TreeNode): (Int, Boolean) = {
            if(curr == null) return (0, true)
            
            val left = getMaxHeights(curr.left)
            val right = getMaxHeights(curr.right)
            
            if(left._2 == false || right._2 == false || (left._1 - right._1).abs > 1){
                return (0, false)
            }

            return ((left._1).max(right._1) + 1, true)
        }
        
        getMaxHeights(root)._2
    }
}
