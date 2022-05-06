def dfs(cur, cnt):
    if cnt == M:
        print(*answer)
        return

    prev = 0
    for next in range(cur, N):
        if not used[next] and prev != l[next]:
            prev = l[next]
            used[next] = True
            answer.append(l[next])
            dfs(next + 1, cnt + 1)
            used[next] = False
            answer.pop()


N, M = map(int, input().split())
l = sorted(list(map(int, input().split())))
used = [False for _ in range(N)]
answer = []

dfs(0, 0)
