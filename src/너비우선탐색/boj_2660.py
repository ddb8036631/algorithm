from collections import deque

N = int(input())
adj = [[] for _ in range(N + 1)]
visit = [[False] * (N + 1) for _ in range(N + 1)]
dist = [[0] * (N + 1) for _ in range(N + 1)]
minScore = 1e9
answer = []

while True:
    a, b = map(int, input().split())
    if a == -1 and b == -1:
        break
    adj[a].append(b)
    adj[b].append(a)

for i in range(1, N + 1):
    queue = deque()
    queue.append(i)
    visit[i][i] = True
    cnt = 0

    while queue:
        size = len(queue)
        for _ in range(size):
            now = queue.popleft()
            dist[i][now] = cnt

            for next in adj[now]:
                if visit[i][next]:
                    continue
                visit[i][next] = True
                queue.append(next)
        cnt += 1

for i in range(1, N + 1):
    minScore = min(minScore, max(dist[i]))

for i in range(1, N + 1):
    if max(dist[i]) == minScore:
        answer.append(i)

print(minScore, len(answer))
print(*answer)
