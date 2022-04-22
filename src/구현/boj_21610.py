N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
move = [list(map(int, input().split())) for _ in range(M)]
cloud = [[N - 1, 0], [N - 1, 1], [N - 2, 0], [N - 2, 1]]
d = [[0, -1], [-1, -1], [-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1]]
answer = 0

for dir, dist in move:
    visit = [[False] * N for _ in range(N)]

    for i in range(len(cloud)):
        cloud[i][0] = (cloud[i][0] + d[dir - 1][0] * dist) % N
        cloud[i][1] = (cloud[i][1] + d[dir - 1][1] * dist) % N
        board[cloud[i][0]][cloud[i][1]] += 1

    while cloud:
        y, x = cloud.pop()
        visit[y][x] = True
        cnt = 0

        for i in range(1, len(d), 2):
            ny, nx = y + d[i][0], x + d[i][1]
            if ny < 0 or ny >= N or nx < 0 or nx >= N or board[ny][nx] == 0:
                continue
            cnt += 1
        board[y][x] += cnt

    for y in range(N):
        for x in range(N):
            if not visit[y][x] and board[y][x] >= 2:
                cloud.append([y, x])
                board[y][x] -= 2

print(sum(sum(arr) for arr in board))
