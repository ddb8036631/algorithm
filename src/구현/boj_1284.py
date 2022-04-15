while True:
    n = input()
    w = 0

    if n == "0":
        break

    for ch in n:
        if ch == "1":
            w += 2
        elif ch == "0":
            w += 4
        else:
            w += 3

    w += len(n) + 1
    print(w)
