# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root == None:
            return []
        queue = [(root, 0)]
        d = {}
        
        while queue:
            v = queue[0]
            
            if v[1] in d:
                d[v[1]].append(v[0].val)
            else:
                d[v[1]] = [v[0].val]
                
            queue = queue[1:]
            
            
            if v[0].left != None:
                queue.append((v[0].left, v[1] + 1))
                
            if v[0].right != None:
                queue.append((v[0].right, v[1] + 1))
        
        i = 0
        res = []
        while i in d:
            res.append(d[i])
            i = i + 1
        return res
            
        
