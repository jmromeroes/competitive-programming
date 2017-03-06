#!/bin/python3

import sys


n = int(input().strip())
c = [int(c_temp) for c_temp in input().strip().split(' ')]
d = {}

for i in c:
    if i in d:
        d[i] = d[i] + 1
    else:
        d[i] = 1

socks = 0
for k, value in d.items():
    socks = int(socks + value/2)

print(socks)
