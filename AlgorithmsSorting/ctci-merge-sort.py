from collections import deque

def count_merge(l1, l2):
    l3 = []
    c = 0
    
    while l1 or l2:
        if not l1 or not l2:
            l3 = l3 + l1 + l2
            l1 = []
            l2 = []
        elif l1[0] <= l2[0]:
            l3 = l3 + [l1[0]]
            del l1[0]
        else:
            l3 = l3 + [l2[0]]
            del l2[0]
            c = c + len(l1)
    return (l3, c)
  
def count_inversions(a):
    if len(a) == 1 or len(a) == 0:
      return (a, 0)
    else:
      c1 = count_inversions(a[:len(a)//2])
      c2 = count_inversions(a[len(a)//2:])
      r = count_merge(c1[0], c2[0])
      return (r[0], c1[1] + c2[1] + r[1])      

t = int(input().strip())
for a0 in range(t):
    n = int(input().strip())
    arr = list(map(int, input().strip().split(' ')))
    print(count_inversions(arr)[1])
