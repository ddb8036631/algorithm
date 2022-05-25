import sys
from heapq import heappush, heappop

input = sys.stdin.readline
N, M = map(int, input().split())
adj = [[] for _ in range(N + 1)]
pq = []
visit = [False for _ in range(N + 1)]
max_cost, answer = 0, 0

for _ in range(M):
    a, b, c = map(int, input().split())
    adj[a].append((b, c))
    adj[b].append((a, c))

heappush(pq, (0, 1))

while N:
    cost, now = heappop(pq)
    if visit[now]:
        continue
    N -= 1
    visit[now] = True
    max_cost = max(max_cost, cost)
    answer += cost

    for next, cost in adj[now]:
        if visit[next]:
            continue
        heappush(pq, (cost, next))

print(answer - max_cost)
