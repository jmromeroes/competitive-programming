l = list(map(int, input().strip().split(" ")))
print(l)
x = sum(l)
print(x - max(l), x - min(l))
