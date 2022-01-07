def rotate(s, ul, dl, ll, rl):
    tx = ty = s
    i = 0
    while True:
        tx, ty = tx + d[i][0], ty + d[i][1]
        if tx == ul or tx == dl or ty == ll or ty == rl:
            tx, ty = tx - d[i][0], ty - d[i][1]
            i += 1
            tx, ty = tx + d[i][0], ty + d[i][1]
        if tx == s and ty == s:
            return
        arr[s][s], arr[tx][ty] = arr[tx][ty], arr[s][s]


N, M, R = map(int, input().split(" "))
arr = [input().split() for _ in range(N)]
d = [(1, 0), (0, 1), (-1, 0), (0, -1)]
cnt = min(N, M) // 2

for s in range(cnt):
    for _ in range(R % (2 * (N + M - 4 * s - 2))):
        rotate(s, s - 1, N - s, s - 1, M - s)


for row in arr:
    print(*row)
