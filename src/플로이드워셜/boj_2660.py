N = int(input())
dist = [[1e9] * (N + 1) for _ in range(N + 1)]
answer = []

while True:
    a, b = map(int, input().split())
    if a == -1 and b == -1:
        break
    dist[a][b] = dist[b][a] = 1

for i in range(1, N + 1):
    dist[i][i] = 0

for k in range(1, N + 1):
    for i in range(1, N + 1):
        for j in range(1, N + 1):
            if dist[i][j] == 1 or dist[i][j] == 0:
                continue
            if dist[i][j] > dist[i][k] + dist[k][j]:
                dist[i][j] = dist[i][k] + dist[k][j]

for i in range(1, N + 1):
    answer.append(max(dist[i][1:]))

minScore = min(answer)
print(minScore, answer.count(minScore))

for i, v in enumerate(answer, 1):
    if v == minScore:
        print(i, end=" ")
