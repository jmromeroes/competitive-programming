#!/bin/python3

import sys


n,k = input().strip().split(' ')
n,k = [int(n),int(k)]
heights = list(map(int, input().strip().split(' ')))
# your code goes here

print(max(heights) - k if max(heights) - k > 0 else 0)
