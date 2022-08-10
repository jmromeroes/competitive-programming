/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
import scala.collection.mutable.Map

object Solution {
    def levelOrderBottom(root: TreeNode): List[List[Int]] = {
        val m: Map[Int, List[Int]] = Map()
        var maxLevel: Int = 0
        
        def populateMap(curr: TreeNode, level: Int): Unit = {
            if(curr == null) return;
            if(maxLevel < level) maxLevel = level
            
            m.get(level) match {
                case None =>
                    m(level) = List(curr.value)
                case Some(xs) =>
                    m(level) = xs :+ curr.value
            }
            
            populateMap(curr.left, level + 1)
            populateMap(curr.right, level + 1)
            
        }
        
        populateMap(root, 1)
        
        var l: List[List[Int]] = List()
        for(i <- maxLevel until 0 by -1){
            l = l :+ m(i)
        }
        
        l
    }
}
