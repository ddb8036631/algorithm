import sys

input = sys.stdin.readline
N, M = map(int, input().split())
adj = [[False for _ in range(N + 1)] for _ in range(N + 1)]
answer = 0

for _ in range(M):
    a, b = map(int, input().split())
    adj[a][b] = adj[b][a] = True

for a in range(1, N + 1):
    for b in range(a + 1, N + 1):
        for c in range(b + 1, N + 1):
            if adj[a][b] or adj[a][c] or adj[b][c]:
                continue
            answer += 1

print(answer)
