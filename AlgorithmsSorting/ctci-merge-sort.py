def count_merge(l1, l2):
    c = 0   
    i_l1 = 0
    i_l2 = 0
    l_l1 = len(l1)
    l_l2 = len(l2)
    l3 = [0] * (l_l1 + l_l2)
    i_l3 = 0
    while i_l1 < l_l1 or i_l2 < l_l2:
        if i_l1 == l_l1:
            for i in range(i_l2, l_l2):
                l3[i_l3] = l2[i]
                i_l3 = i_l3 + 1
            i_l1 = l_l1
            i_l2 = l_l2
        elif i_l2 == l_l2:
            for i in range(i_l1, l_l1):
                l3[i_l3] = l1[i]
                i_l3 = i_l3 + 1
            i_l1 = l_l1
            i_l2 = l_l2
        elif l1[i_l1] <= l2[i_l2]:
            l3[i_l3] = l1[i_l1]
            i_l3 = i_l3 + 1
            i_l1 = i_l1 + 1
        else:
            l3[i_l3] = l2[i_l2]
            i_l3 = i_l3 + 1
            i_l2 = i_l2 + 1
            c = c + l_l1 - i_l1
    return (l3, c)
  
def count_inversions(a, s, e):
    if e - s <= 0:
      return ([a[s]], 0)
    else:
      c1 = count_inversions(a, s, s + (e - s)//2)
      c2 = count_inversions(a, s + (e - s)//2 + 1, e)
      r = count_merge(c1[0], c2[0])
      return (r[0], c1[1] + c2[1] + r[1])      

t = int(input())
for a0 in range(t):
    n = int(input())
    arr = [int(x) for x in input().split(' ')]
    print(count_inversions(arr, 0, n - 1)[1])
