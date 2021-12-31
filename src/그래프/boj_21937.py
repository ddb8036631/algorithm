import sys
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().split())
graph, visit = [[] for _ in range(N + 1)], [False] * (N + 1)
answer = 0

for _ in range(M):
    u, v = map(int, input().split())
    graph[v].append(u)

X = int(input())
queue = deque()
queue.append(X)
visit[X] = True

while queue:
    now = queue.popleft()

    for next in graph[now]:
        if visit[next]:
            continue
        visit[next] = True
        queue.append(next)
        answer += 1


print(answer)
