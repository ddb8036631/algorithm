from collections import deque
from itertools import combinations
from sys import stdin

input = stdin.readline
N, M, G, R = map(int, input().split())
d = [[-1, 0], [1, 0], [0, -1], [0, 1]]
board, soil = [], []
green_queue, red_queue = deque(), deque()
max_cnt = 0

for i in range(N):
    l = list(map(int, input().split()))

    for j in range(M):
        if l[j] == 2:
            soil.append([i, j])

    board.append(l)


for all in combinations(soil, R + G):
    for green in combinations(all, G):
        visit = [[[] for _ in range(M)] for _ in range(N)]
        flowers = [[False for _ in range(M)] for _ in range(N)]
        red = [[x, y] for [x, y] in all if [x, y] not in green]
        time = 1

        for (gx, gy) in green:
            visit[gx][gy] = [0, "green"]
            green_queue.append([gx, gy])
        for [rx, ry] in red:
            visit[rx][ry] = [0, "red"]
            red_queue.append([rx, ry])

        while green_queue or red_queue:
            for _ in range(len(green_queue)):
                gx, gy = green_queue.popleft()
                if flowers[gx][gy]:
                    continue
                for dx, dy in d:
                    ngx, ngy = gx + dx, gy + dy
                    if (
                        ngx < 0
                        or ngx >= N
                        or ngy < 0
                        or ngy >= M
                        or board[ngx][ngy] == 0
                        or visit[ngx][ngy]
                        or flowers[ngx][ngy]
                    ):
                        continue
                    visit[ngx][ngy] = [time, "green"]
                    green_queue.append([ngx, ngy])

            for _ in range(len(red_queue)):
                rx, ry = red_queue.popleft()
                if flowers[rx][ry]:
                    continue
                for dx, dy in d:
                    nrx, nry = rx + dx, ry + dy
                    if nrx < 0 or nrx >= N or nry < 0 or nry >= M or board[nrx][nry] == 0 or flowers[nrx][nry]:
                        continue
                    if not visit[nrx][nry]:
                        visit[nrx][nry] = [time, "red"]
                        red_queue.append([nrx, nry])
                    elif visit[nrx][nry][0] == time and visit[nrx][nry][1] == "green":
                        flowers[nrx][nry] = True

            time += 1

        cnt = sum([sum(1 for x in flowers[i] if x == True) for i in range(N)])
        max_cnt = max(max_cnt, cnt)

print(max_cnt)
