from collections import deque

n = int(input())
board = [list(map(int, input())) for _ in range(n)]
visit = [[1e9 for _ in range(n)] for _ in range(n)]
queue = deque()
d = [[-1, 0], [1, 0], [0, -1], [0, 1]]
visit[0][0] = 0
queue.append([0, 0, 0])
answer = 1e9

while queue:
    x, y, cnt = queue.popleft()
    if x == n - 1 and y == n - 1:
        answer = min(answer, cnt)
    for dx, dy in d:
        nx, ny = x + dx, y + dy
        if nx < 0 or nx >= n or ny < 0 or ny >= n:
            continue
        if board[nx][ny] == 0 and visit[nx][ny] > cnt + 1:
            visit[nx][ny] = cnt + 1
            queue.append([nx, ny, visit[nx][ny]])
        if board[nx][ny] == 1 and visit[nx][ny] > cnt:
            visit[nx][ny] = cnt
            queue.append([nx, ny, visit[nx][ny]])

print(answer)
