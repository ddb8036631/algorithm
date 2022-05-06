def dfs(cur):
    global max_cnt

    if cur == N:
        cnt = 0
        for s in S:
            if s <= 0:
                cnt += 1
        max_cnt = max(max_cnt, cnt)
        return

    found = False

    if S[cur] > 0:
        for next in range(N):
            if cur == next or S[next] <= 0:
                continue

            found = True
            S[cur] -= W[next]
            S[next] -= W[cur]

            dfs(cur + 1)

            S[cur] += W[next]
            S[next] += W[cur]
        if not found:
            dfs(cur + 1)
    else:
        dfs(cur + 1)


N = int(input())
S, W = [0 for _ in range(N)], [0 for _ in range(N)]
max_cnt = 0

for i in range(N):
    S[i], W[i] = map(int, input().split())

dfs(0)
print(max_cnt)
