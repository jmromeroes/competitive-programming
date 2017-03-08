n = input()
l = input().strip().split(" ")
v = l[-1]

for i in reversed(range(len(l) - 1)):
    l[i + 1] = l[i]
    
    if l[i] < v:
       l[i + 1] = v
       print(*l, sep=' ')
       break
    elif i == 0:
       print(*l, sep=' ')
       l[i] = v

    print(*l, sep=' ')
