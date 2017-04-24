#!/bin/python3
import sys

n,k = input().strip().split(' ')
n,k = [int(n),int(k)]
x = sorted([int(x_temp) for x_temp in input().strip().split(' ')])
b = [False] * n
r = 0
for i in range(n):
    if not b[i]:
        orig = x[i]
        j = i + 1
        p = 0
        b[i] = True
        
        while j < n and x[j] - orig <= k:
            p = j
            b[j] = True
            j += 1
        
        h = p + 1
        while h < n and x[h] - x[p] <= k:
            b[h] = True
            h += 1

        h = h - 1
        r = r + 1
        
print(r)
