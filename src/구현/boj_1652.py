N = int(input())
board = [list(input()) + ["X", "X"] for _ in range(N)]
board.extend([["X" for _ in range(N + 2)] for _ in range(2)])
hor, ver = 0, 0

for i in range(N):
    for j in range(N):
        hor += 1 if board[i][j] == "." and board[i][j + 1] == "." and board[i][j + 2] == "X" else 0
        ver += 1 if board[i][j] == "." and board[i + 1][j] == "." and board[i + 2][j] == "X" else 0

print(hor, ver)
