from collections import defaultdict
from sys import stdin
import heapq

input = stdin.readline
N, M, K, X = map(int, input().split())
graph = defaultdict(list)
dist = [float("inf")] * (N + 1)
visit = [False] * (N + 1)
pq = []
answer = []

for _ in range(M):
    A, B = map(int, input().split())
    graph[A].append(B)

visit[X] = True
dist[X] = 0
heapq.heappush(pq, (0, X))

while pq:
    cost, now = heapq.heappop(pq)
    if cost == K:
        answer.append(str(now))
        continue
    if cost > K:
        break
    for next in graph[now]:
        if visit[next]:
            continue
        if dist[next] > cost + 1:
            dist[next] = cost + 1
            visit[next] = True
            heapq.heappush(pq, (cost + 1, next))

print("\n".join(answer) if answer else -1)
