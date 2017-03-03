n = int(input())

def swap(s, i, j):
    return s[:i]+s[j]+s[i+1:j]+s[i]+s[j+1:]    

def getStringFromUnsorted(s):
    for i in reversed(range(len(s))):
        if i > 0 and s[i] > s[i-1]:
            return i-1

    return 0
        
for i in range(n):
    b = False
    s = input()
    s1 = s[:getStringFromUnsorted(s)]
    s2 = s[getStringFromUnsorted(s):]

    for y in reversed(range(len(s2))):
        for x in reversed(range(y)):
            if s2[x] < s2[y]:
                s3 = swap(s2, x, y)
                if s3 > s2:
                    s3 = s3[:x+1] +  ''.join(sorted(s3[x+1:]))
                    b = True
                    break
        if b: break
    
    if len(s) == 1 or b is False:
        print("no answer")
    else:
        print(s1 + s3)
