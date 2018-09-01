#!/bin/python3

import math
import os
import random
import re
import sys

# This works but too slow
# Complete the sherlockAndAnagrams function below.
def sherlockAndAnagrams(s):
    d = {}
    for i in range(len(s)):
        for j in  range(i + 1, len(s) + 1):
            if (j - i) in d:
                d[j- i].append(s[i:j])
            else:
                d[j - i] = [s[i:j]]
    
    count = 0
    for i in d:
        l = d[i]

        for x in range(len(l) - 1):
            for y in range(x+1, len(l)):
                d2 = {}
                if sorted(l[x]) == sorted(l[y]):          
                    count = count + 1
    return count
            
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input())

    for q_itr in range(q):
        s = input()

        result = sherlockAndAnagrams(s)

        fptr.write(str(result) + '\n')

    fptr.close()
