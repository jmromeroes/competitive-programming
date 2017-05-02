def getExpression(data, v, op, i):
    if i == len(data) - 1:
        if(op == '+'):
            if (v + data[i]) % 101 == 0:
                return("+"+str(data[i]), True)
            else:
                return("", False)
        elif(op == '-'):
            if (v - data[i]) % 101 == 0:
                return("-"+str(data[i]), True)
            else:
                return("", False)
        else:
            if (v * data[i]) % 101 == 0:
                return("*"+str(data[i]), True)
            else:
                return("", False)
    else:
        if op == ' ':
            
            h = getExpression(data, data[i], '*', i + 1)
            if h[1]:
                return (str(data[i])+h[0], True)
            print("2")
            
            h = getExpression(data, data[i], '+', i + 1)
            if h[1]:
                return (str(data[i])+h[0], True)
            h = getExpression(data, data[i], '-', i + 1)
            print("3")
            
            if h[1]:
                return (str(data[i])+h[0], True)
            return(" ", False)
        elif op == '*':
            h = getExpression(data, v * data[i], '*', i + 1)
            if h[1]:
                return ("*"+str(data[i])+h[0], True)
            
            h = getExpression(data, v * data[i], '+', i + 1)
            if h[1]:
                return ("*"+str(data[i])+h[0], True)
            
            h = getExpression(data, v * data[i], '-', i + 1)
            if h[1]:
                return ("*"+str(data[i])+h[0], True)
            
            return(" ", False)
        elif op == '+':
            h = getExpression(data, v + data[i], '*', i + 1)
            if h[1]:
                return ("+"+str(data[i])+h[0], True)
            
            h = getExpression(data, v + data[i], '+', i + 1)
            if h[1]:
                return ("+"+str(data[i])+h[0], True)
            
            h = getExpression(data, v + data[i], '-', i + 1)
            if h[1]:
                return ("+"+str(data[i])+h[0], True)
            
            return(" ", False)
        else:
            h = getExpression(data, v - data[i], '*', i + 1)
            if h[1]:
                return ("-"+str(data[i])+h[0], True)
            
            h = getExpression(data, v - data[i], '+', i + 1)
            if h[1]:
                return ("-"+str(data[i])+h[0], True)
            
            h = getExpression(data, v - data[i], '-', i + 1)
            if h[1]:
                return ("-"+str(data[i])+h[0], True)
            
            return(" ", False)
        
input()      
print(getExpression([int(x) for x in input().split(' ')], 0, ' ', 0)[0])
