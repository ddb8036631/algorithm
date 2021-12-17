from sys import stdin
from collections import deque

N, A, B = [*map(int, stdin.readline().split())]
graph = [[] * N for _ in range(N)]
queue = deque()
visit = [False] * N
answer = 0

for _ in range(N - 1):
    u, v, d = [*map(int, stdin.readline().split())]
    graph[u - 1].append((v - 1, d))
    graph[v - 1].append((u - 1, d))

queue.append((A - 1, 0, 0))
visit[A - 1] = True

while queue:
    now, max_dist, sum = queue.popleft()

    if now == B - 1:
        print(sum - max_dist)
        break

    for nv, nd in graph[now]:
        if visit[nv] == True:
            continue

        visit[nv] = True
        queue.append((nv, max(max_dist, nd), sum + nd))
