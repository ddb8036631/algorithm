A = int(input())
T = int(input())
target = int(input())
b, d, n = 0, 0, 1

while True:
    for i in range(4):
        if i % 2 == 0:
            b += 1
        else:
            d += 1
        if target == 0 and b == T:
            print((b + d - 1) % A)
            exit()
        if target == 1 and d == T:
            print((b + d - 1) % A)
            exit()
    for _ in range(n + 1):
        b += 1
        if target == 0 and b == T:
            print((b + d - 1) % A)
            exit()
    for _ in range(n + 1):
        d += 1
        if target == 1 and d == T:
            print((b + d - 1) % A)
            exit()
    n += 1
