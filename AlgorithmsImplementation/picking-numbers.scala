#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the pickingNumbers function below.
def pickingNumbers(a):
    a = sorted(a)
    d = {}
    
    for i in a:
        if i in d:
            d[i].append(i)
        else:
            d[i] = [i]
            
        if i - 1 in d:
            d[i - 1].append(i)
        
        if i + 1 in d:
            d[i + 1].append(i)
        
    return max(map(len, d.values()))

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    a = list(map(int, input().rstrip().split()))

    result = pickingNumbers(a)

    fptr.write(str(result) + '\n')

    fptr.close()
