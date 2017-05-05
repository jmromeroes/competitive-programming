t = int(input())

for _ in range(t):
    n, k = [int(x) for x in input().split(" ")]
    a = sorted([int(x) for x in input().split(" ")])
    b = sorted([int(x) for x in input().split(" ")], reverse=True)
    r = True
    
    for i in range(n):
        if a[i] + b[i] < k:
            r = False
            break
     
    if r:
        print("YES")
    else:
        print("NO")
