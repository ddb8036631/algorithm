import sys
import heapq
from collections import defaultdict

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
INF = int(1e9)
graph = defaultdict(list)
dist = [INF] * (N + 1)

for _ in range(M):
    u, v, c = list(map(int, sys.stdin.readline().split()))
    graph[u].append((v, c))

s, e = list(map(int, sys.stdin.readline().split()))


def dijkstra(start):
    queue = []
    heapq.heappush(queue, (start, 0))

    while queue:
        now, cost = heapq.heappop(queue)

        if dist[now] < cost:
            continue

        for nv, nc in graph[now]:
            if dist[nv] > cost + nc:
                dist[nv] = cost + nc
                heapq.heappush(queue, (nv, dist[nv]))


dijkstra(s)
print(dist[e])
