#!/bin/python3

import math
import os
import random
import re
import sys
        
# Complete the whatFlavors function below.
def whatFlavors(cost, money):
    d = {}
    for c in range(len(cost)):
        if money - cost[c] in d:
            print(str(d[money-cost[c]] + 1)+" "+str(c+1))
        else:
            d[cost[c]] = c
    
if __name__ == '__main__':
    t = int(input())

    for t_itr in range(t):
        money = int(input())

        n = int(input())

        cost = list(map(int, input().rstrip().split()))

        whatFlavors(cost, money)
