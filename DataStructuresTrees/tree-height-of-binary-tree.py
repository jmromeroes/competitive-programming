# Enter your code here. Read input from STDIN. Print output to STDOUT
'''
class Node:
      def __init__(self,info): 
          self.info = info  
          self.left = None  
          self.right = None 
           

       // this is a node of the tree , which contains info as data, left , right
'''
def height(root):
    def h(root):
        if root == None:
            return 0
        else:
            l = h(root.left)
            r = h(root.right)
        
            return 1 + (l if l > r else r)
        
    return h(root) - 1
