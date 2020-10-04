/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
import scala.collection.mutable._

case class TreeNodeWrapper(treeNode: TreeNode, level: Int)
object Solution {
    def isEvenOddTree(root: TreeNode): Boolean = {
        if(root == null) return false
        
        val queue: Queue[TreeNodeWrapper] = Queue(TreeNodeWrapper(root, 0))
        var lastElement: Int = -1
        var shouldIncrease = true
        var lastLevel = -1
        
        while(!queue.isEmpty){
            val currElement: TreeNodeWrapper = queue.dequeue
            
            if(currElement.level != lastLevel){
                lastLevel = currElement.level
                shouldIncrease = lastLevel % 2 == 0
                lastElement = -1
            }
            
            if((shouldIncrease != (currElement.treeNode.value % 2 != 0)))
                return false
            if(shouldIncrease && (lastElement != -1 && lastElement >= currElement.treeNode.value)){
                return false       
            } else if(!shouldIncrease && (lastElement != -1 && lastElement <= currElement.treeNode.value)){
                return false
            } else {
                lastElement = currElement.treeNode.value
                
                if(currElement.treeNode.left != null){
                    queue += TreeNodeWrapper(currElement.treeNode.left, currElement.level + 1)
                }
                
                if(currElement.treeNode.right != null){
                    queue += TreeNodeWrapper(currElement.treeNode.right, currElement.level + 1)
                }
            }
        }
        
        true
    }
}
