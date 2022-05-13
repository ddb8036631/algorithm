N, M, K = map(int, input().split())
board = [[0 for _ in range(M)] for _ in range(N)]
stickers = [[] for _ in range(K)]
answer = 0


def rotate(sticker, r, c):
    tmp = [[0 for _ in range(r)] for _ in range(c)]
    for x in range(r):
        for y in range(c):
            tmp[y][r - 1 - x] = sticker[x][y]
    return tmp


def attach(k):
    for _ in range(4):
        sticker = stickers[k]
        r, c = len(sticker), len(sticker[0])

        for x in range(N):
            for y in range(M):
                lx, ly = x + r, y + c

                if lx <= N and ly <= M and canAttach(sticker, x, y, r, c):
                    for dx in range(r):
                        for dy in range(c):
                            board[x + dx][y + dy] |= sticker[dx][dy]
                    return

        stickers[k] = rotate(sticker, r, c)


def canAttach(sticker, x, y, r, c):
    for dx in range(r):
        for dy in range(c):
            nx, ny = x + dx, y + dy
            if board[nx][ny] == 1 and sticker[dx][dy] == 1:
                return False

    return True


for k in range(K):
    R, C = map(int, input().split())
    for _ in range(R):
        stickers[k].append(list(map(int, input().split())))

for k in range(K):
    attach(k)

print(sum([sum(board[i]) for i in range(N)]))
