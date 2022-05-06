from collections import deque


n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
visit = [[False for _ in range(m)] for _ in range(n)]
d = [[-1, 0], [1, 0], [0, -1], [0, 1]]
picture_cnt = 0
max_width = 0

for i in range(n):
    for j in range(m):
        if board[i][j] and not visit[i][j]:
            picture_cnt += 1
            visit[i][j] = True
            queue = deque()
            queue.append([i, j])
            width = 0

            while queue:
                x, y = queue.popleft()
                width += 1
                for dx, dy in d:
                    nx, ny = x + dx, y + dy
                    if nx < 0 or nx >= n or ny < 0 or ny >= m or visit[nx][ny] or board[nx][ny] == 0:
                        continue
                    visit[nx][ny] = True
                    queue.append([nx, ny])
            max_width = max(max_width, width)

print(picture_cnt, max_width, sep="\n")
