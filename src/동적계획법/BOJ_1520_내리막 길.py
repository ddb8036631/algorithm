import sys

input = sys.stdin.readline
sys.setrecursionlimit(10 ** 4)
M, N = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(M)]
dp = [[-1 for _ in range(N)] for _ in range(M)]
dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]


def dfs(x, y):
    if x == M - 1 and y == N - 1:
        return 1
    if dp[x][y] != -1:
        return dp[x][y]

    dp[x][y] = 0
    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0 <= nx < M and 0 <= ny < N and board[x][y] > board[nx][ny]:
            dp[x][y] += dfs(nx, ny)

    return dp[x][y]


print(dfs(0, 0))
