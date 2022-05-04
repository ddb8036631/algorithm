N = int(input())
size = 1001
board = [[0] * size for _ in range(size)]
answer = [0 for _ in range(N + 1)]

for k in range(1, N + 1):
    x, y, w, h = map(int, input().split())
    for i in range(x, x + w):
        for j in range(y, y + h):
            board[i][j] = k

for i in range(size):
    for j in range(size):
        answer[board[i][j]] += 1


print("\n".join(map(str, answer[1:])))
