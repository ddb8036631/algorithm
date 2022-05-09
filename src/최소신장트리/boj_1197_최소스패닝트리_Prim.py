V, E = map(int, input().split())
adj = [[] for _ in range(V + 1)]
pi = [0 for _ in range(V + 1)]
key = [1e9 for _ in range(V + 1)]
visit = [False for _ in range(V + 1)]

for _ in range(E):
    A, B, C = map(int, input().split())
    adj[A].append([B, C])
    adj[B].append([A, C])

pi[1] = -1
key[1] = 0

for _ in range(V - 1):
    min = 1e9
    cur = -1

    for i in range(1, V + 1):
        if not visit[i] and min > key[i]:
            min = key[i]
            cur = i

    visit[cur] = True

    for next, cost in adj[cur]:
        if not visit[next] and key[next] > cost:
            pi[next] = cur
            key[next] = cost

print(sum(key[1:]))
