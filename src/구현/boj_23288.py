from collections import deque

N, M, K = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
dice = [[0, 2, 0], [4, 1, 3], [0, 5, 0], [0, 6, 0]]
d = [[-1, 0], [0, 1], [1, 0], [0, -1]]
x, y, dir = 0, 0, 1
answer = 0


def initDir():
    global dir
    if dir == 0 and x + d[dir][0] < 0:
        dir = 2
    elif dir == 1 and y + d[dir][1] >= M:
        dir = 3
    elif dir == 2 and x + d[dir][0] >= N:
        dir = 0
    elif dir == 3 and y + d[dir][1] < 0:
        dir = 1


def move():
    global x, y
    if dir == 0:
        dice[0][1], dice[1][1] = dice[1][1], dice[0][1]
        dice[1][1], dice[2][1] = dice[2][1], dice[1][1]
        dice[2][1], dice[3][1] = dice[3][1], dice[2][1]
    elif dir == 1:
        dice[3][1], dice[1][2] = dice[1][2], dice[3][1]
        dice[1][2], dice[1][1] = dice[1][1], dice[1][2]
        dice[1][1], dice[1][0] = dice[1][0], dice[1][1]
    elif dir == 2:
        dice[3][1], dice[2][1] = dice[2][1], dice[3][1]
        dice[2][1], dice[1][1] = dice[1][1], dice[2][1]
        dice[1][1], dice[0][1] = dice[0][1], dice[1][1]
    else:
        dice[3][1], dice[1][0] = dice[1][0], dice[3][1]
        dice[1][0], dice[1][1] = dice[1][1], dice[1][0]
        dice[1][1], dice[1][2] = dice[1][2], dice[1][1]

    x, y = x + d[dir][0], y + d[dir][1]


def setScore():
    global x, y, answer
    num = board[x][y]
    q = deque([[x, y]])
    visit = [[False] * M for _ in range(N)]
    cnt = 0
    visit[x][y] = True

    while q:
        px, py = q.popleft()
        cnt += 1
        for dx, dy in d:
            nx, ny = px + dx, py + dy
            if nx < 0 or nx >= N or ny < 0 or ny >= M or visit[nx][ny] or board[nx][ny] != num:
                continue
            visit[nx][ny] = True
            q.append([nx, ny])

    answer += num * cnt


def setDir():
    global dir
    down, num = dice[3][1], board[x][y]
    if down > num:
        dir = (dir + 1) % 4
    elif down < num:
        dir = (dir - 1) % 4


for _ in range(K):
    initDir()
    move()
    setScore()
    setDir()

print(answer)
