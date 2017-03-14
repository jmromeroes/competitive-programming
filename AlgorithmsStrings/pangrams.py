s = input().lower()
b = True
for c in range(97, 123):
    if not chr(c) in s:
        b = False
        break
print("pangram" if b else "not pangram") 
