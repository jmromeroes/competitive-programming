# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __init__(self):
        self.m = [0, 0]
    
    def findBottomLeftValueA(self, root, c):
        if root.left == None and root.right == None:
            if c > self.m[1]:
                self.m[1] = c
                self.m[0] = root.val
        if root.left != None:
            self.findBottomLeftValueA(root.left, c + 1)
        if root.right != None:
            self.findBottomLeftValueA(root.right, c + 1)
        
    def findBottomLeftValue(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.m[0] = root.val
        if root.left != None:
            self.findBottomLeftValueA(root, 0)
        if root.right != None:
            self.findBottomLeftValueA(root, 0)
        
        return self.m[0]
        
