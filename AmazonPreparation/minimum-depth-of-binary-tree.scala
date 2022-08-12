/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def minDepth(root: TreeNode): Int = {
        if(root == null) return 0
        
        def minD(node: TreeNode, level: Int): Int = {
            if(node.right == null && node.left == null){
                return level
            }
            
            if(node.right == null)
                return minD(node.left, level + 1)
            
            if(node.left == null)
                return minD(node.right, level + 1)
            
            minD(node.right, level + 1).min(minD(node.left, level + 1))
        }
        
        minD(root, 1)
    }
}
