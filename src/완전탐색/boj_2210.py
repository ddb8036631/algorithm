def dfs(pos, cnt, tmp):
    if cnt == 6:
        answer.add(tmp)
        return

    for dx, dy in d:
        nx, ny = pos[0] + dx, pos[1] + dy
        if nx < 0 or nx >= 5 or ny < 0 or ny >= 5:
            continue
        dfs((nx, ny), cnt + 1, tmp + arr[nx][ny])


arr = [input().split() for _ in range(5)]
d = [(-1, 0), (1, 0), (0, -1), (0, 1)]
answer = set()
for i in range(5):
    for j in range(5):
        dfs((i, j), 1, arr[i][j])

print(len(answer))
