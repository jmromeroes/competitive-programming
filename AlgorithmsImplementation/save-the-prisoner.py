t = int(input(""))

for i in range(t):
    n,m,s = [int(x) for x in input("").split(" ")]
    r = 0
    
    if m > s:
        md = m % n
        mds = md + s - 1

        if mds > n:
            r = mds - n
        else:
            r = mds            
    
    print(r if r != 0 else n)
