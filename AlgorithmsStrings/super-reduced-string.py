s = input()

i = 0
while i < len(s) - 1:
    if s[i] == s[i + 1]:
        if i != 0:
            s = s[:i] + s[i+2:]
            i = i - 2
        else:
            s = s[i+2:]

    if len(s) == 2:
        i = -1

    i = i + 1
print(s if len(s) > 0 else "Empty String")
