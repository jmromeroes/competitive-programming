def op(x):

    if (x % 3 == 1):
        return x % 3
    else: 
        return x + op(x-1)
print(op(12))
    
def permuteS(s):
    if len(s) == 1:
        return [s]
    elif len(s) == 0:
        return []
    else:
        res = []

        for i in range(len(s)):
            c = s[i]
            l = permuteS(s[:i] + s[i+1:])
            for h in l:
                res.append(s[i] + h)

        return res

def permute(s):
    for w in permuteS(s):
        print(w)

def combineHelper(s):
    if len(s) == 1:
        return [s]
    elif len(s) == 0:
        return[]
    else:
        res = []
        l = []
        h = combineHelper(s[1:])
        for w in h:
            res.append(w)
            res.append(s[0] + w)

        return res
            
    
def combine(s):
    for c in combineHelper(s):
        print(c)
