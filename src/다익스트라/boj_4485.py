import sys
import heapq

input = sys.stdin.readline
d = [(-1, 0), (1, 0), (0, -1), (0, 1)]
INF = int(1e9)
case = 0

while True:
    N = int(input())
    if N == 0:
        break

    case += 1
    _map = [list(map(int, input().split())) for _ in range(N)]
    queue = []
    visited = [[False] * N for _ in range(N)]
    heapq.heappush(queue, (_map[0][0], (0, 0)))

    while queue:
        cost, (x, y) = heapq.heappop(queue)
        if x == N - 1 and y == N - 1:
            print("Problem %d: %d" % (case, cost))
            break

        for dx, dy in d:
            nx, ny = x + dx, y + dy

            if nx < 0 or nx >= N or ny < 0 or ny >= N or visited[nx][ny]:
                continue

            if not visited[nx][ny]:
                heapq.heappush(queue, (_map[nx][ny] + cost, (nx, ny)))
                visited[nx][ny] = True
