n = input()
l = [int(x) for x in input().strip().split(" ")]

for y in range(1, len(l)):
    v = l[y]
    for x in reversed(range(y + 1)):
        l[x] = l[x - 1]
                  
        if l[x - 1] < v or x == 0:
            l[x] = v
            break
        else:
            l[x - 1] = v
    
    print(*l, sep=' ')
