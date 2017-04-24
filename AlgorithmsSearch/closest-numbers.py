import math, sys 

n = int(input())
l = sorted([int(x) for x in input().split(" ")])
d = {}
min = sys.maxsize

for i in range(0, n - 1):
    v = math.fabs(l[i + 1] - l[i]) 
    if v in d:
        d[v].append(str(l[i]))
        d[v].append(str(l[i + 1]))
    else:
        d[v] = [str(l[i]), str(l[i + 1])]
    if v < min:
      min = v
      
print(" ".join(d[min]))
