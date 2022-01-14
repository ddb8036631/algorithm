from collections import deque

N, M = map(int, input().split(" "))
arr = [list(input()) for _ in range(M)]
visit = [[False] * N for _ in range(M)]
d = [(-1, 0), (1, 0), (0, -1), (0, 1)]
w, b = 0, 0
for i in range(M):
    for j in range(N):
        if not visit[i][j]:
            queue = deque()
            color = arr[i][j]
            queue.append((i, j))
            visit[i][j] = True
            cnt = 1

            while queue:
                x, y = queue.popleft()
                for dx, dy in d:
                    nx, ny = x + dx, y + dy
                    if nx < 0 or nx >= M or ny < 0 or ny >= N or visit[nx][ny] or arr[nx][ny] != color:
                        continue
                    visit[nx][ny] = True
                    queue.append((nx, ny))
                    cnt += 1
            if color == "W":
                w += cnt * cnt
            else:
                b += cnt * cnt
print(w, b)
