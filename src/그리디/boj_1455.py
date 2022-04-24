N, M = map(int, input().split())
board = [list(map(int, input())) for _ in range(N)]
answer = 0


def reverse(x, y):
    for i in range(x + 1):
        for j in range(y + 1):
            board[i][j] = 1 - board[i][j]


for i in range(N - 1, -1, -1):
    for j in range(M - 1, -1, -1):
        if board[i][j]:
            reverse(i, j)
            answer += 1

print(answer)
