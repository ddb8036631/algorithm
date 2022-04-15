N = int(input())
map = [list(input()) for _ in range(N)]
answer = [[0] * N for _ in range(N)]
d = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]
for x in range(N):
    for y in range(N):
        if map[x][y] != ".":
            for dx, dy in d:
                nx, ny = x + dx, y + dy
                if nx < 0 or nx >= N or ny < 0 or ny >= N:
                    continue
                answer[nx][ny] += int(map[x][y])

for x in range(N):
    for y in range(N):
        if map[x][y] != ".":
            answer[x][y] = "*"
        elif answer[x][y] >= 10:
            answer[x][y] = "M"

for arr in answer:
    l = "".join(str(x) for x in arr)
    print(l)
