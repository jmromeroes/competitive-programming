#!/bin/python3

import sys


n,m = input().strip().split(' ')
n,m = [int(n),int(m)]
a = [int(a_temp) for a_temp in input().strip().split(' ')]
b = [int(b_temp) for b_temp in input().strip().split(' ')]
results = []
for i in range(max(a), min(b)+1):
    is_factor = True
    for x in range(0, max(n,m)):
        if x < n:
            if i % a[x] != 0:
                is_factor = False
                break
        
        if x < m:
            if b[x] % i != 0:
                is_factor = False
                break
    if is_factor:    
        results.append(i)
            
print(len(results))
