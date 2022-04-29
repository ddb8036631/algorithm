N, K = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
chessMap = [[[] for _ in range(N)] for _ in range(N)]
chess = [0 for _ in range(K + 1)]
d = [[], [0, 1], [0, -1], [-1, 0], [1, 0]]
answer = 1

for i in range(1, K + 1):
    r, c, dir = map(int, input().split())
    chessMap[r - 1][c - 1].append(i)
    chess[i] = [r - 1, c - 1, dir]

while answer < 1000:
    for i in range(1, K + 1):
        x, y, dir = chess[i]
        if chessMap[x][y][0] != i:
            continue

        nx, ny = x + d[dir][0], y + d[dir][1]

        if nx < 0 or nx >= N or ny < 0 or ny >= N or board[nx][ny] == 2:
            if dir % 2 == 0:
                dir -= 1
            else:
                dir += 1

            chess[i][2] = dir
            nx, ny = x + d[dir][0], y + d[dir][1]

            if nx < 0 or nx >= N or ny < 0 or ny >= N or board[nx][ny] == 2:
                continue

        tmp = [*chessMap[x][y]]

        if board[nx][ny] == 1:
            tmp = tmp[::-1]

        chessMap[nx][ny] = [*chessMap[nx][ny], *tmp]
        chessMap[x][y] = []

        for i in tmp:
            chess[i][:2] = [nx, ny]

        if len(chessMap[nx][ny]) >= 4:
            print(answer)
            exit()

    answer += 1

print(-1)
