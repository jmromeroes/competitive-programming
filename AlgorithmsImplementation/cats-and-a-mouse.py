#!/bin/python3

import sys
import math

q = int(input().strip())
for a0 in range(q):
    x,y,z = input().strip().split(' ')
    x,y,z = [int(x),int(y),int(z)]
    a1 = math.fabs(x - z)
    a2 = math.fabs(y - z)
    
    if a1 < a2:
        print("Cat A")
    elif a1 > a2:
        print("Cat B")
    else:
        print("Mouse C")  
