from collections import defaultdict, deque
from sys import stdin

input = stdin.readline
N = int(input())
graph = defaultdict(list)
parent = [0] * (N + 1)
queue = deque()

for _ in range(N - 1):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

queue.append(1)
parent[1] = -1

while queue:
    now = queue.popleft()

    for next in graph[now]:
        if parent[next]:
            continue
        parent[next] = now
        queue.append(next)

print("\n".join(map(str, parent[2:])))
