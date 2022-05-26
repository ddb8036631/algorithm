size, MAX = 10, 101
board = [list(map(int, input().split())) for _ in range(size)]
paper = [0 for _ in range(5)]
answer = MAX


def dfs(x, y, cnt):
    global answer
    if y == size:
        dfs(x + 1, 0, cnt)
        return

    if x == size:
        answer = min(answer, cnt)
        return

    if board[x][y] == 1:
        for d in range(5):
            limit_x, limit_y = x + d + 1, y + d + 1
            if paper[d] == 5 or not canAttach(x, y, limit_x, limit_y):
                continue
            attach(x, y, limit_x, limit_y)
            paper[d] += 1
            dfs(x, limit_y, cnt + 1)
            detach(x, y, limit_x, limit_y)
            paper[d] -= 1
    else:
        dfs(x, y + 1, cnt)


def canAttach(x1, y1, x2, y2):
    if x2 > size or y2 > size:
        return False
    for i in range(x1, x2):
        for j in range(y1, y2):
            if board[i][j] == 0:
                return False
    return True


def attach(x1, y1, x2, y2):
    for i in range(x1, x2):
        for j in range(y1, y2):
            board[i][j] = 0


def detach(x1, y1, x2, y2):
    for i in range(x1, x2):
        for j in range(y1, y2):
            board[i][j] = 1


dfs(0, 0, 0)
print(answer if answer != MAX else -1)
