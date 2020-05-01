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
    
    ArrayList<Integer> listIntegerReference = new ArrayList();
    
    private void populateList(TreeNode root) {
        if(root == null){
            return;
        }    
        
        populateList(root.left);
        listIntegerReference.add(root.val);
        populateList(root.right);
    }
    
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        populateList(root);
        
        int maxValue = listIntegerReference.get(0);
        for(int i=1; i<listIntegerReference.size(); i++){
            if(listIntegerReference.get(i) <= maxValue) {
                return false;
            }
            maxValue = listIntegerReference.get(i);
        }
        return true;
    }
}
