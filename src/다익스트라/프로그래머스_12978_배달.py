import sys
from heapq import heappush, heappop


def solution(N, road, K):
    adj = [[] for _ in range(N + 1)]
    dist = [sys.maxsize for _ in range(N + 1)]
    pq = []

    for a, b, c in road:
        adj[a].append([b, c])
        adj[b].append([a, c])

    dist[1] = 0
    heappush(pq, [0, 1])

    while pq:
        cost, cur = heappop(pq)

        for next, time in adj[cur]:
            if dist[next] > cost + time:
                dist[next] = cost + time
                heappush(pq, [dist[next], next])

    return sum([cost <= K for cost in dist[1:]])


print(solution(5, [[1, 2, 1], [2, 3, 3], [5, 2, 2], [1, 4, 2], [5, 3, 1], [5, 4, 2]], 3))
print(solution(6, [[1, 2, 1], [1, 3, 2], [2, 3, 2], [3, 4, 3], [3, 5, 2], [3, 5, 3], [5, 6, 1]], 4))
