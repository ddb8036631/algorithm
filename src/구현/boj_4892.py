tc = 0

while True:
    tc += 1
    n0 = int(input())
    if n0 == 0:
        break
    n1 = 3 * n0
    n2 = n1 // 2 if n1 % 2 == 0 else (n1 + 1) // 2
    n3 = 3 * n2
    n4 = n3 // 9
    print(str(tc) + ". " + ("even" if n1 % 2 == 0 else "odd") + " " + str(n4))
