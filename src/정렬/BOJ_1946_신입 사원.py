from sys import stdin

input = stdin.readline
T = int(input())

for _ in range(T):
    N = int(input())
    rank = [0 for _ in range(N + 1)]
    limit = N

    for _ in range(N):
        s, m = map(int, input().split())
        rank[s] = m

    for i in range(1, N + 1):
        if rank[i] > limit:
            N -= 1
        else:
            limit = min(limit, rank[i])

    print(N)
