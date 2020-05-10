/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

class Solution {
    
    public ResultNode lowestCommonAncestorRecursion(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        
        if(root == p){
            ResultNode leftChild = lowestCommonAncestorRecursion(root.left, p, q);
            
            if(leftChild != null && leftChild.node == q)
                return new ResultNode(p, true);
            
            ResultNode rightChild = lowestCommonAncestorRecursion(root.right, p, q);
            if(rightChild != null && rightChild.node == q)
                return new ResultNode(p, true);
            
            return new ResultNode(p, false);
        } else if(root == q) {
            ResultNode leftChild = lowestCommonAncestorRecursion(root.left, p, q);
            
            if(leftChild != null && leftChild.node == p)
                return new ResultNode(q, true);
            
            ResultNode rightChild = lowestCommonAncestorRecursion(root.right, p, q);
            
            if(rightChild != null && rightChild.node == p)
                return new ResultNode(q, true);
            
            return new ResultNode(q, false);
        } else {
            ResultNode leftChild = lowestCommonAncestorRecursion(root.left, p, q);
            ResultNode rightChild = lowestCommonAncestorRecursion(root.right, p, q);
            
            if(leftChild != null && leftChild.isAncestor) {
                return leftChild;
            } else if(rightChild != null && rightChild.isAncestor){
                return rightChild;
            } else if((leftChild != null && (leftChild.node == p || leftChild.node == q)) && 
               (rightChild != null && (rightChild.node == p || rightChild.node == q))) {
                return new ResultNode(root, true);
            } else if(leftChild != null && (leftChild.node == p || leftChild.node == q)) {
                return leftChild;
            } else if((rightChild != null && (rightChild.node == p || rightChild.node == q))) {
                return rightChild;
            }
        }
        
        return null;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestorRecursion(root, p, q).node;
    }
    
    private class ResultNode {
        TreeNode node;
        boolean isAncestor;
        
        ResultNode(TreeNode node, boolean isAncestor){
            this.node = node;
            this.isAncestor = isAncestor;
        }
    }
}
