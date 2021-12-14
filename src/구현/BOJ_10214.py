for _ in range(int(input())):
    yy = kk = 0
    for _ in range(9):
        Y, K = map(int, input().split())
        yy += Y
        kk += K


    if yy > kk: print("Yonsei")
    elif yy < kk: print("Korea")
    else: print("Draw")

