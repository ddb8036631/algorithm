s = input()

for ch in s:
    next = ord(ch) + 13

    if ch.isupper():
        if next > ord("Z"):
            next -= 26
    elif ch.islower():
        if next > ord("z"):
            next -= 26
    else:
        next -= 13

    print(chr(next), end="")
