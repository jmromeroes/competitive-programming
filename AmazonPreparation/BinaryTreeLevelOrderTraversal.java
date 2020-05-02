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
import java.util.*;

class Solution {
    private HashMap<TreeNode, Integer> levelByNodeReference = new HashMap();
    private HashMap<Integer, List<Integer>> nodesByLevel = new HashMap();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        
        if(root == null){
            return new ArrayList();    
        }
        
        queue.add(root);
        levelByNodeReference.put(root, 0);
        nodesByLevel.put(0, new ArrayList(Arrays.asList(root.val)));
        while(queue.size() != 0) {
            TreeNode queueHead = queue.poll();
            if(queueHead.left != null){
                queue.add(queueHead.left);
                int currNodeLevel = levelByNodeReference.get(queueHead)+1;
                levelByNodeReference.put(queueHead.left, currNodeLevel);
                
                if(nodesByLevel.containsKey(currNodeLevel)){
                    nodesByLevel.get(currNodeLevel).add(queueHead.left.val);
                } else {
                    nodesByLevel.put(currNodeLevel, new ArrayList(Arrays.asList(queueHead.left.val)));
                } 
            }
            
            if(queueHead.right != null){
                queue.add(queueHead.right);
                int currNodeLevel = levelByNodeReference.get(queueHead)+1;
                levelByNodeReference.put(queueHead.right, currNodeLevel);
                
                if(nodesByLevel.containsKey(currNodeLevel)){
                    nodesByLevel.get(currNodeLevel).add(queueHead.right.val);
                } else {
                    nodesByLevel.put(currNodeLevel, new ArrayList(Arrays.asList(queueHead.right.val)));
                } 
            }
            
            System.out.println(nodesByLevel);
        }
        
        int index = 0;
        ArrayList<List<Integer>> resultList = new ArrayList();
        while(nodesByLevel.containsKey(index)) {
            resultList.add(nodesByLevel.get(index));
            index++;
        }
        
        return resultList;
    }
}
