/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */

import scala.collection.mutable.Stack
import scala.collection.mutable.Map

object Solution {
    def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
        val length = inorder.length
        val positions: Map[Int, Int] = Map()
        var taken = 1
        
        for(i <- 0 until length){
            positions(inorder(i)) = i
        }
            
        def inRange(position: Int, range: (Int, Int)): Boolean = {
            position >= range._1 && position <= range._2
        }
        
        def buildTreeRec(current: TreeNode, leftBound: Int, rightBound: Int): TreeNode = {
            if(taken >= length) return current
            
            var nextValue = preorder(taken)
            val currentPosition = positions(current.value)
            val hasLeftChildren = inRange(positions(nextValue), (leftBound, currentPosition - 1))
            
            if(hasLeftChildren){
                taken += 1
                current.left = buildTreeRec(new TreeNode(nextValue), leftBound, currentPosition - 1)
            }