from copy import deepcopy

M, S = map(int, input().split())
board = [[[] for _ in range(4)] for _ in range(4)]
smell = [[0 for _ in range(4)] for _ in range(4)]
fish_dir = [[0, -1], [-1, -1], [-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1]]
shark_dir = [[-1, 0], [0, -1], [1, 0], [0, 1]]
answer = 0

for _ in range(M):
    x, y, d = map(int, input().split())
    board[x - 1][y - 1].append(d - 1)

shark = list(map(lambda x: int(x) - 1, input().split()))


def fishMove():
    global board
    tmp = [[[] for _ in range(4)] for _ in range(4)]
    for x in range(4):
        for y in range(4):
            while board[x][y]:
                d = board[x][y].pop()
                for i in range(d, d - 8, -1):
                    i %= 8
                    nx, ny = x + fish_dir[i][0], y + fish_dir[i][1]
                    if nx < 0 or nx >= 4 or ny < 0 or ny >= 4 or (nx == shark[0] and ny == shark[1]) or smell[nx][ny]:
                        continue
                    tmp[nx][ny].append(i)
                    break
                else:
                    tmp[x][y].append(d)

    board = tmp


def dfs(x, y, depth, cnt, visit):
    global shark, eat, max_cnt
    if depth == 3:
        if cnt > max_cnt:
            max_cnt = cnt
            shark = [x, y]
            eat = visit[:]

        return

    for dx, dy in shark_dir:
        nx, ny = x + dx, y + dy
        if nx < 0 or nx >= 4 or ny < 0 or ny >= 4:
            continue
        if [nx, ny] not in visit:
            visit.append([nx, ny])
            dfs(nx, ny, depth + 1, cnt + len(board[nx][ny]), visit)
            visit.pop()
        else:
            dfs(nx, ny, depth + 1, cnt, visit)

    return


for _ in range(S):
    tmp = deepcopy(board)
    max_cnt = -1
    eat = []

    fishMove()
    dfs(shark[0], shark[1], 0, 0, [])

    for x, y in eat:
        if board[x][y]:
            board[x][y] = []
            smell[x][y] = 3

    for x in range(4):
        for y in range(4):
            if smell[x][y]:
                smell[x][y] -= 1
            board[x][y] += tmp[x][y]

for x in range(4):
    for y in range(4):
        answer += len(board[x][y])

print(answer)
