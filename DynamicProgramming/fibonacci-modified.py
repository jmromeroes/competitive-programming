t1,t2,tn = input().strip().split(" ")
t1 = int(t1)
t2 = int(t2)
tn = int(tn)

for i in range(2, tn):
    taux = int(t1) + int(t2**2)
    t1 = t2
    t2 = taux

print(t2)
    
