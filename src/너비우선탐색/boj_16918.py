import sys


def findBomb(q):
    for y in range(R):
        for x in range(C):
            if map[y][x] == "O":
                q.append((y, x))


def setBomb():
    for y in range(R):
        for x in range(C):
            if map[y][x] == ".":
                map[y][x] = "O"


def bomb(q):
    while q:
        y, x = q.pop()
        map[y][x] = "."
        for dy, dx in d:
            ny, nx = y + dy, x + dx
            if ny < 0 or ny >= R or nx < 0 or nx >= C:
                continue
            map[ny][nx] = "."


input = sys.stdin.readline
R, C, N = map(int, input().split())
N -= 1
map = [list(input().strip()) for _ in range(R)]
d = [(-1, 0), (1, 0), (0, -1), (0, 1)]
prev, next = [], []

for y in range(R):
    for x in range(C):
        if map[y][x] == "O":
            prev.append((y, x))

while N:
    queue = []
    findBomb(queue)
    setBomb()
    N -= 1
    if N == 0:
        break
    bomb(queue)
    N -= 1


for arr in map:
    print("".join(arr))
