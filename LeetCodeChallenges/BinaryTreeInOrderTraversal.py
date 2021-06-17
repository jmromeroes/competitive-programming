# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        if root == None:
            return []
        
        result_list = []
        
        def inorderRecursion(current_node: TreeNode):
            if current_node.left != None:
                inorderRecursion(current_node.left)
                
            result_list.append(current_node.val)
            
            if current_node.right != None:
                inorderRecursion(current_node.right)
            
        inorderRecursion(root)
        
        return result_list
