N = int(input())
board = [[]]
answer = 1e9

for _ in range(N):
    board.append([0] + list(map(int, input().split())))


def calc(x, y, d1, d2):
    sector = [[0] * (N + 1) for _ in range(N + 1)]
    cnt = [0, 0, 0, 0, 0, 0]

    for i in range(d1 + 1):
        sector[x + i][y - i] = 5
        sector[x + d2 + i][y + d2 - i] = 5
    for i in range(d2 + 1):
        sector[x + i][y + i] = 5
        sector[x + d1 + i][y - d1 + i] = 5

    for i in range(x + 1, x + d1 + d2):
        isBorder = False
        for j in range(1, N + 1):
            if sector[i][j] == 5:
                isBorder = not isBorder
            if isBorder:
                sector[i][j] = 5

    for r in range(1, N + 1):
        for c in range(1, N + 1):
            if r < x + d1 and c <= y and sector[r][c] == 0:
                cnt[1] += board[r][c]
            elif r <= x + d2 and y < c and sector[r][c] == 0:
                cnt[2] += board[r][c]
            elif x + d1 <= r and c < y - d1 + d2 and sector[r][c] == 0:
                cnt[3] += board[r][c]
            elif x + d2 < r and y - d1 + d2 <= c and sector[r][c] == 0:
                cnt[4] += board[r][c]
            else:
                cnt[5] += board[r][c]

    return max(cnt[1:]) - min(cnt[1:])


for x in range(1, N + 1):
    for y in range(1, N + 1):
        for d1 in range(1, N + 1):
            for d2 in range(1, N + 1):
                if 1 <= x < x + d1 + d2 <= N and 1 <= y - d1 < y < y + d2 <= N:
                    answer = min(answer, calc(x, y, d1, d2))

print(answer)
