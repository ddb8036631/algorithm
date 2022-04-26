from collections import deque

N, M, K = map(int, input().split())
board = [[5] * N for _ in range(N)]
soil = [list(map(int, input().split())) for _ in range(N)]
trees = [[deque() for _ in range(N)] for _ in range(N)]
d = [[-1, -1], [-1, 0], [-1, 1], [0, -1], [0, 1], [1, -1], [1, 0], [1, 1]]
answer = 0

for _ in range(M):
    x, y, z = map(int, input().split())
    trees[x - 1][y - 1].append(z)

for year in range(K):
    dead = []

    for x in range(N):
        for y in range(N):
            if not trees[x][y]:
                continue

            for _ in range(len(trees[x][y])):
                age = trees[x][y].popleft()

                if board[x][y] >= age:
                    trees[x][y].append(age + 1)
                    board[x][y] -= age
                else:
                    dead.append([x, y, age])

    while dead:
        x, y, age = dead.pop()
        board[x][y] += age // 2

    for x in range(N):
        for y in range(N):
            board[x][y] += soil[x][y]

            if not trees[x][y]:
                continue

            for age in trees[x][y]:
                if age % 5:
                    continue

                for dx, dy in d:
                    nx, ny = x + dx, y + dy
                    if nx < 0 or nx >= N or ny < 0 or ny >= N:
                        continue
                    trees[nx][ny].appendleft(1)

for x in range(N):
    for y in range(N):
        answer += len(trees[x][y])

print(answer)
