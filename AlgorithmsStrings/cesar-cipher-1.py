#!/bin/python3
import sys
import math

n = int(input().strip())
s = list(input().strip())
k = int(input().strip())

for i in range(n):
    s1 = ord(s[i])
    
    if s1 in range(65, 91):
        if k % 26 + s1 > 90:
            s[i] = chr(k % 26 + s1 - 91 + 65) 
        else:
            s[i] = chr(k % 26 + s1)
            
    elif s1 in range(97, 123):
        if k % 26 + s1 > 122:
            s[i] = chr(k % 26 + s1 - 123 + 97) 
        else:
            s[i] = chr(k % 26 + s1)
            
print(''.join(s))
