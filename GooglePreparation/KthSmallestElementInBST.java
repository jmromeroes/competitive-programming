/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    
    def kthSmallest(root: TreeNode, k: Int): Int = {
        var currentIndex: Int = 0;
        var result: Option[Int] = None;
        
        def recursiveKthSmallest(root: TreeNode, k: Int): Boolean = {
            if(root == null){
                return false
            }

            result match {
                case Some(v) => return true
                case None =>
                    recursiveKthSmallest(root.left, k)

                    currentIndex += 1

                    if(k == currentIndex){
                        result = Some(root.value)
                        return true
                    } 

                    recursiveKthSmallest(root.right, k)
                    return true
            }

        }
        
        recursiveKthSmallest(root, k)
        return result match {
            case None => 0
            case Some(v) => v
        }
    }
    
}
