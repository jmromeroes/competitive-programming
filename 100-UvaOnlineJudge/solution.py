"""https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=36"""
solutions = []

inp = input("")

def evaluate(n):
    count = 1

    while n != 1:
        count = count + 1
        if n % 2 == 0:
            n = n / 2
        else:
            n = (3 * n) + 1

    return count

ij = inp.split(" ")    
while len(ij) == 2:
    i  = ij[0]
    j  = ij[1]
    sol = 0

    for r in range(int(i), int(j)+1):
        z = evaluate(r)
        sol = z if z > sol else sol
        
    solutions.append("" + str(i) + " " + str(j) + " " + str(sol))
    inp = input("")
    ij = inp.split(" ")    

for s in solutions:
    print (s)


