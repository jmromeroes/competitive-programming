x#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the substrCount function below.
def substrCount2(n, s):
    count = 0
    for i in range(n - 1):
        for j in range(i + 1, n):
            curr = i
            shouldBeEqual = False
            if j - curr % 2 == 0:
                shouldBeEqual = True
            c = s[curr]
            right = True
            while curr < j:
                if s[curr] != c:
                    if curr != (j - i // 2):
                        right = False
                        break
                curr = curr + 1
            if right:
                count = count + 1
    return count + 2

def substrCount(n, s):
    count = 0
    
    lp = []
    lc = None
    for i in range(n):
        cur = s[i]
        if not lc:
            lc = cur
            lp.append((cur, 1))
        else:
            if cur == lc:
                lp[len(lp)-1] = (lp[len(lp)-1][0], lp[len(lp)-1][1] + 1)
                count = count + lp[len(lp)-1][1] 
            else:
                lc = cur
                lp.append((cur, 1))
    
    for i in range(len(lp)):
        if i + 2 > len(lp) - 1:
            break
        else:
            if lp[i][0] == lp[i + 2][0] and lp[i + 1][1] == 1:
                count = count + min(lp[i + 2][1], lp[i][1])
    
    print(lp)
    return count + len(lp)
        
        
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    s = input()

    result = substrCount(n, s)

    fptr.write(str(result) + '\n')

    fptr.close()
