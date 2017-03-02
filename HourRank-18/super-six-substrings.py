ss = input()
n = 0

for i in range(len(ss)):
    for index in range(i+1, len(ss)+1):
        l = ss[i:index]
            
        if len(l) > 0 and l[0] == "0":
            n += 1
            break

        if len(l) > 0 and int(l) % 6 == 0:
            n += 1

print(n)
