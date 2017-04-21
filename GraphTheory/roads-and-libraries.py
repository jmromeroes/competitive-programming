q = int(input())

def getCost(withAccess, mor, mdes, starting, clib, croad, init):
    if not withAccess[starting]:
        withAccess[starting] = True
        res = clib if init else croad

        if starting in mor:
            for i in mor[starting]:
                if not withAccess[i]:
                    res += getCost(withAccess, mor, mdes, i, clib, croad, False)

        if starting in mdes:
            for i in mdes[starting]:
                if not withAccess[i]:
                    res += getCost(withAccess, mor, mdes, i, clib, croad, False)

        print("{} {} {}".format(res, starting, init))
        return res
    else:
        return 0
        
    
for i0 in range(q):
    n, m, clib, croad = [int(x) for x in input().split(" ")]
    withAccess = [False] * n
    res = 0
    mapOri = {}
    mapDest = {}

    for i1 in range(m):
        c1, c2 = [int(x) - 1 for x in input().split(" ")]

        if c1 in mapOri:
            mapOri[c1].append(c2)
        else:
            mapOri[c1] = [c2]

        if c2 in mapDest:
            mapDest[c2].append(c1)
        else:
            mapDest[c2] = [c1]
    
    if(croad > clib):
        res = clib * n
    else:
        for i in range(n):
            if not withAccess[i]:
                res += getCost(withAccess, mapOri, mapDest, i, clib, croad, True)
        
    print(res)
