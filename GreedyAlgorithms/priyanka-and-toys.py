n = int(input(""))
c = 1
l = sorted([int(x) for x in input().split(" ")])
aux = int(l[0])

for i in l:
    if i > aux + 4:
        c += 1
        aux = i
        
print(c)
    
