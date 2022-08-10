/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def sortedArrayToBST(nums: Array[Int]): TreeNode = {
        def buildTree( leftBound: Int, rightBound: Int): TreeNode = {
            if(leftBound > rightBound) return null
            
            if(leftBound == rightBound){
                return TreeNode(nums(leftBound))
            }
            
            if(rightBound - leftBound == 1){
                if(nums(rightBound) > nums(leftBound)){
                    return new TreeNode(nums(rightBound), TreeNode(nums(leftBound)), null)
                }
                return new TreeNode(nums(leftBound), TreeNode(nums(rightBound)), null)
            }
            
            val middle = (rightBound + leftBound) / 2
            TreeNode(nums(middle), buildTree(leftBound, middle - 1), buildTree(middle + 1, rightBound))
        }
        
        buildTree(0, nums.length - 1)
    }
}
