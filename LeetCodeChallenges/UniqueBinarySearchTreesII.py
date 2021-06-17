# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def greater_values(self, v: int, l: List[int]):
        return list(filter(lambda x: x > v, l))
    
    def lower_values(self, v: int, l: List[int]):
        return list(filter(lambda x: x < v, l))
    
    def generateTrees(self, n: int) -> List[TreeNode]:
        if n == 0:
            return []
        
        def generateRecursion(pending_nodes: List[int]) -> List[TreeNode]:
            if len(pending_nodes) == 1:
                return [TreeNode(pending_nodes[0])]
            
            result_list = []
            for current_node in pending_nodes:
                result_ref = []
                results_lower = []
                lower_values = self.lower_values(current_node, pending_nodes) 
                
                results_greater = []
                greater_values = self.greater_values(current_node, pending_nodes)
                
                for result in generateRecursion(lower_values):
                    results_lower.append(result)
                
                for result in generateRecursion(greater_values):
                    results_greater.append(result)
                                
                if len(results_lower) and len(results_greater):
                    for res_lower in results_lower:
                        for res_greater in results_greater:
                            new_node = TreeNode(current_node)
                            new_node.left = res_lower
                            new_node.right = res_greater
                            result_list.append(new_node)
                elif len(results_lower):
                    for res_lower in results_lower:
                        new_node = TreeNode(current_node)
                        new_node.left = res_lower
                        result_list.append(new_node)
                else:
                    for res_greater in results_greater:
                        new_node = TreeNode(current_node)
                        new_node.right = res_greater
                        result_list.append(new_node)
                        
                        
            return result_list
            
        return generateRecursion(list(range(1, n+1)))
