#!/bin/python3
import sys

n,t = input().strip().split(' ')
n,t = [int(n),int(t)]
cs  = list(map(int, input().strip().split(' ')))
res = 0
h = n

for c in range(len(cs)):
    h = h - cs[c]
    if h < 5 and c != len(cs) - 1:
        r = n - h
        res = res + r
        h = h + r
        
print(res)
# your code goes here
