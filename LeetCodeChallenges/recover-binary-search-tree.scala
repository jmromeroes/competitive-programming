/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */

import scala.collection.mutable.ArrayBuffer

object Solution {
    
    def swapNodes(node1: TreeNode, node2: TreeNode): Unit = {
        val tempValue = node1.value;
        node1.value = node2.value
        node2.value = tempValue
    }
    
    def inorder(root: TreeNode): Unit = {
        var max = 0
        var maxNode: TreeNode = null;
        
        val s = ArrayBuffer.empty[Int];
        
        def getConflictingNodes(node: TreeNode): (TreeNode, TreeNode) = {
            if(node.left != null){
                val conflicting = getConflictingNodes(node.left)
                
                if(conflicting != null){
                    return conflicting
                }
            }
            
            if(node.value < max && maxNode != null && !s.contains(node.value)){
                if(s.isEmpty)
                    s += max
                
                s += node.value
                return (maxNode, node)
            } else {
                max = node.value
                maxNode = node
            }
            
            if(node.right != null) {
                val conflicting = getConflictingNodes(node.right)
                
                if(conflicting != null){
                    return conflicting
                }
                
            }
            
            null;
        }
        
        val conflictingNodes = getConflictingNodes(root)
        println(conflictingNodes)
        max = 0
        maxNode = null;
        val conflictingNodes2 = getConflictingNodes(root)
        println(conflictingNodes2)
        if(conflictingNodes2 == null){
            swapNodes(conflictingNodes._1, conflictingNodes._2)
        } else {
            if(s(0) > s(1) && s(1) > s(2)){
                swapNodes(conflictingNodes._1, conflictingNodes2._2)
            }
        }
    }
    
    def recoverTree(root: TreeNode): Unit = {
        inorder(root)
    }
}
