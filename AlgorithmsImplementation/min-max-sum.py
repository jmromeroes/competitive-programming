l = list(map(int, input().strip().split(" ")))
x = sum(l)
print(x - max(l), x - min(l))
