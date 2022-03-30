/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
        if(p == null || q == null){
            return p == q;
        }
        
        if(!isSameTree(p.left, q.left)){
            return false
        }
        
        if(p.value != q.value){
            return false
        }
        
        if(!isSameTree(p.right, q.right)){
            return false
        }
        
        return true;
    }
}
