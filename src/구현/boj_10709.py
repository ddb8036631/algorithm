H, W = map(int, input().split())
arr = [list(input()) for _ in range(H)]

for i in range(H):
    for j in range(W):
        if arr[i][j] == ".":
            arr[i][j] = -1
        elif arr[i][j] == "c":
            arr[i][j] = 0
            cnt = 1

            for k in range(j + 1, W):
                if arr[i][k] == ".":
                    arr[i][k] = cnt
                    cnt += 1
                if arr[i][k] == "c":
                    break

for i in range(H):
    for j in range(W):
        print(arr[i][j], end=" ")
    print()
