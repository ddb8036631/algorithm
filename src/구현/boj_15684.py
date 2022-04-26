import sys


def dfs(y, x, cnt):
    global answer

    if cnt >= answer:
        return

    if check():
        answer = min(answer, cnt)
        return

    if cnt == 3:
        return

    for ny in range(y, H):
        k = x if ny == y else 0
        for nx in range(k, N - 1):
            if board[ny][nx]:
                continue

            board[ny][nx] = True
            dfs(ny, nx + 2, cnt + 1)
            board[ny][nx] = False


def check():
    for start in range(N):
        ny, nx = 0, start
        while ny < H:
            if board[ny][nx]:
                nx += 1
            elif nx - 1 >= 0 and board[ny][nx - 1]:
                nx -= 1
            ny += 1
        if nx != start:
            return False
    return True


input = sys.stdin.readline
N, M, H = map(int, input().split())
board = [[False] * N for _ in range(H)]
answer = 4

for _ in range(M):
    a, b = map(int, input().split())
    board[a - 1][b - 1] = True

dfs(0, 0, 0)
print(answer if answer < 4 else -1)
