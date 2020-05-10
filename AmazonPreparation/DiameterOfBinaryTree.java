/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxDiameter = 0;
    
    public int diameterOfBinaryTreeRecursion(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int L = diameterOfBinaryTreeRecursion(root.left);
        int R = diameterOfBinaryTreeRecursion(root.right);
        
        maxDiameter = Math.max(maxDiameter, L+R);
        
        return Math.max(L, R) + 1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTreeRecursion(root);
        
        return maxDiameter;
    }
}
