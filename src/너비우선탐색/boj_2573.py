from collections import deque

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
d = [[-1, 0], [1, 0], [0, -1], [0, 1]]
answer = 1

while True:
    visit = [[False] * M for _ in range(N)]
    for i in range(N):
        for j in range(M):
            if board[i][j] >= 1 and not visit[i][j]:
                tmpBoard = [[0] * M for _ in range(N)]
                for ii in range(N):
                    for jj in range(M):
                        tmpBoard[ii][jj] = board[ii][jj]
                queue = deque()
                visit[i][j] = True
                queue.append([i, j])

                while queue:
                    x, y = queue.popleft()
                    cnt = 0

                    for dx, dy in d:
                        nx, ny = x + dx, y + dy
                        if nx < 0 or nx >= N or ny < 0 or ny >= M:
                            continue
                        if board[nx][ny] <= 0:
                            cnt += 1
                        elif board[nx][ny] >= 1 and not visit[nx][ny]:
                            visit[nx][ny] = True
                            queue.append([nx, ny])
                    tmpBoard[x][y] -= cnt

    board = tmpBoard
    visit = [[False] * M for _ in range(N)]
    splitCnt = 0

    for i in range(N):
        for j in range(M):
            if splitCnt >= 2:
                print(answer)
                exit()
            if board[i][j] >= 1 and not visit[i][j]:
                queue = deque()
                visit[i][j] = True
                queue.append([i, j])

                while queue:
                    x, y = queue.popleft()
                    for dx, dy in d:
                        nx, ny = x + dx, y + dy
                        if nx < 0 or nx >= N or ny < 0 or ny >= M or visit[nx][ny] or board[nx][ny] <= 0:
                            continue
                        visit[nx][ny] = True
                        queue.append([nx, ny])
                splitCnt += 1

    if splitCnt == 0:
        print(0)
        exit()

    answer += 1
