n = input("")
s = input("")
l = 0
r = 0

for c in s:
    if c == 'U':
        l = l + 1
        if l == 0 :
            r += 1
        
    if c == 'D':
        l = l - 1

print(r)     
