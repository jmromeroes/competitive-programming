/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def hasPathSum(root: TreeNode, targetSum: Int): Boolean = {
        if(root == null){
            return false
        }
        
        def hasPath(curr: TreeNode, sum: Int): Boolean = {
            if(curr.left == null && curr.right == null){
                return curr.value + sum == targetSum
            }
            
            if(curr.left == null){
                return hasPath(curr.right, sum + curr.value)
            }
            
            if(curr.right == null){
                return hasPath(curr.left, sum + curr.value)
            }
            
            hasPath(curr.left, sum + curr.value) || hasPath(curr.right, sum + curr.value)
        }
        
        hasPath(root, 0)
    }
}
