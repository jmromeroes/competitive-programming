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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList();
        }
        
        HashMap<Integer, List<Integer>> nodesByLevel = new HashMap();
        HashMap<TreeNode, Integer> levelByNode = new HashMap();
        Queue<TreeNode> bfsQueue = new LinkedList();
        
        bfsQueue.add(root);
        nodesByLevel.put(0, new ArrayList(Arrays.asList(root.val)));
        levelByNode.put(root, 0);
        
        while(bfsQueue.size() > 0){
            TreeNode headNode = bfsQueue.poll();
            
            if(headNode.left != null){
                int currentLevel = levelByNode.get(headNode) + 1;
                bfsQueue.add(headNode.left);
                levelByNode.put(headNode.left, currentLevel);
                
                if(nodesByLevel.containsKey(currentLevel)) {
                    nodesByLevel.get(currentLevel).add(headNode.left.val);
                } else {
                    nodesByLevel.put(currentLevel, new ArrayList(Arrays.asList(headNode.left.val)));
                }
            }
            
            if(headNode.right != null){
                int currentLevel = levelByNode.get(headNode) + 1;
                bfsQueue.add(headNode.right);
                levelByNode.put(headNode.right, currentLevel);
                
                if(nodesByLevel.containsKey(currentLevel)) {
                    nodesByLevel.get(currentLevel).add(headNode.right.val);
                } else {
                    nodesByLevel.put(currentLevel, new ArrayList(Arrays.asList(headNode.right.val)));
                }
            }
        }
        
        int i = 1;
        int index = 0;
        
        ArrayList<List<Integer>> resultList = new ArrayList();
        while(nodesByLevel.containsKey(index)){
            List levelNodes = nodesByLevel.get(index);
            
            if(i == -1) {
                ArrayList levelResultList = new ArrayList();
                
                for(int j=levelNodes.size()-1; j>=0; j--){
                    levelResultList.add(levelNodes.get(j));
                }
                resultList.add(levelResultList);
            } else {
                resultList.add(levelNodes);
            }
            
            index++;
            i=i*-1;
        }
        
        return resultList;
    }
}
