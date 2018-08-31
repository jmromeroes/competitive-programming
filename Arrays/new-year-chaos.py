#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the minimumBribes function below.

def swap(l, i1, i2):
    iaux = l[i1]
    l[i1] = l[i2]
    l[i2] = iaux
    
def minimumBribes(q):
    for i,v in enumerate(q):
        if q[i] - (i + 1) > 2:
            print("Too chaotic")
            return
    
    count = 0

    for i in range(len(q)):
        swaped = False
        for j in range(len(q) - 1):
            if(q[j] > q[j + 1]):
                swaped = True
                count = count + 1
                swap(q, j, j + 1)
        
        if not swaped:
            print(count)
            break
        else:
            swaped = False
    
if __name__ == '__main__':
    t = int(input())

    for t_itr in range(t):
        n = int(input())

        q = list(map(int, input().rstrip().split()))

        minimumBribes(q)
