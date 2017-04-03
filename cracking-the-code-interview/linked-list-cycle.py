

"""
Detect a cycle in a linked list. Note that the head pointer may be 'None' if the list is empty.

A Node is defined as: 
 
    class Node(object):
        def __init__(self, data = None, next_node = None):
            self.data = data
            self.next = next_node
"""


def has_cycle(head):
    aux = head
    while aux != None:
      if aux.next == None or aux.next.next == None: return False
      if aux.next.next == aux: return True
      aux = aux.next
    return False
    
