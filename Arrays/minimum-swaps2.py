#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the minimumSwaps function below.
def swap(l, i1, i2):
    auxi = l[i1]
    l[i1] = l[i2]
    l[i2] = auxi
def minimumSwaps(arr):
    count = 0
    i = 0
    while i < len(arr) - 1:
        if arr[i] != i + 1:
            swap(arr, i, arr[i] - 1)
            count = count + 1
            i = i - 1
            print(i)
        i = i + 1
    print(arr)    
    return count

    
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    arr = list(map(int, input().rstrip().split()))

    res = minimumSwaps(arr)

    fptr.write(str(res) + '\n')

    fptr.close()
