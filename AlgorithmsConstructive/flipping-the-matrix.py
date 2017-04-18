times = int(input())

for t in range(times):
    n = int(input())
    l = []
    r = 0
    
    for i in range(2*n):
        l.append([int(x) for x in input("").split(" ")])
    
    for y in range(n):
        for x in range(n):
            r = r + max([l[y][x], l[y][2*n - x - 1], l[2*n - y - 1][2*n - x - 1], l[2*n - y - 1][x]])
      
    print(r)
  
