n, k = [int(x) for x in input().split(" ")]
l = sorted([int(x) for x in input().split(" ")])
r = 0
for i in l:
  k -= i
  if k < 0:
    break
  else:
    r += 1
    
print(r)
