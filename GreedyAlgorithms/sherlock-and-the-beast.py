#!/bin/python3

import sys

t = int(input().strip())
for a0 in range(t):
    n = int(input().strip())
    tot = n
    
    while n > 0:
      if n % 3 == 0:
          break
      else:
          n = n - 5

    if n < 0:
        print("-1")
    else:
        for i in range(0, n // 3):
            print("555", end = "")
            
        for i in range(0, (tot - n) // 5):
            print("33333", end = "")
        
        print("")
    
