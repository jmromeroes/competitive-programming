#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the arrayManipulation function below.
def arrayManipulation(n, queries):
    l = [0]*n
    for q in queries:
        a, b, k= q
        l[a - 1] = k + l[a - 1]    
        
        if b < n:
            l[b] = l[b] - k
    
    maxc = 0
    for i in range(1, n):
        l[i] = l[i] + l[i - 1]
        if l[i] > maxc:
            maxc = l[i]
    return maxc
            
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nm = input().split()

    n = int(nm[0])

    m = int(nm[1])

    queries = []

    for _ in range(m):
        queries.append(list(map(int, input().rstrip().split())))

    result = arrayManipulation(n, queries)

    fptr.write(str(result) + '\n')

    fptr.close()
