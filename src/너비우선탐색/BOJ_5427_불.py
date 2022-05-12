from sys import stdin
from collections import deque

input = stdin.readline
T = int(input())
d = [[-1, 0], [1, 0], [0, -1], [0, 1]]


def bfs():
    time = 0
    while True:
        if not person:
            return -1

        size = len(fire)
        for _ in range(size):
            fx, fy = fire.popleft()
            for dx, dy in d:
                nfx, nfy = fx + dx, fy + dy
                if nfx < 0 or nfx >= h or nfy < 0 or nfy >= w or board[nfx][nfy] != ".":
                    continue
                board[nfx][nfy] = "*"
                fire.append([nfx, nfy])

        size = len(person)
        for _ in range(size):
            px, py = person.popleft()
            for dx, dy in d:
                npx, npy = px + dx, py + dy
                if npx < 0 or npx >= h or npy < 0 or npy >= w:
                    return time + 1
                if board[npx][npy] == "#" or board[npx][npy] == "*" or visit[npx][npy]:
                    continue
                visit[npx][npy] = True
                person.append([npx, npy])

        time += 1


for _ in range(T):
    w, h = map(int, input().split())
    board = [[] for _ in range(h)]
    fire, person, visit = deque(), deque(), [[False for _ in range(w)] for _ in range(h)]

    for i in range(h):
        board[i] = list(input())
        for j in range(w):
            if board[i][j] == "*":
                fire.append([i, j])
            elif board[i][j] == "@":
                visit[i][j] = True
                person.append([i, j])

    result = bfs()
    print("IMPOSSIBLE" if result == -1 else result)
