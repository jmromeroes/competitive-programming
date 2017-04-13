def is_matched(expression):
    l = []
    for c in expression:
        if c in ('{', '[', '('):
            l.append(c)
        else:
            if len(l) == 0 or \
               (c == '}' and '{' != l.pop()) or \
               (c == ']' and '[' != l.pop()) or \
               (c == ')' and '(' != l.pop()):
              return False
    if len(l) > 0:
      return False
  
    return True

t = int(input().strip())
for a0 in range(t):
    expression = input().strip()
    if is_matched(expression) == True:
        print("YES")
    else:
        print("NO")
