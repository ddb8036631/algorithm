from collections import deque

N = int(input())
dp = [1e9 for _ in range(N + 1)]
q = deque()
dp[N] = 0
q.append([N, [N]])

while q:
    cur, path = q.popleft()
    if cur == 1:
        print(dp[cur])
        print(*path)
        break

    if cur % 3 == 0 and dp[cur // 3] > dp[cur] + 1:
        dp[cur // 3] = dp[cur] + 1
        q.append([cur // 3, [*path, cur // 3]])
    if cur % 2 == 0 and dp[cur // 2] > dp[cur] + 1:
        dp[cur // 2] = dp[cur] + 1
        q.append([cur // 2, [*path, cur // 2]])
    if cur - 1 >= 1 and dp[cur - 1] > dp[cur] + 1:
        dp[cur - 1] = dp[cur] + 1
        q.append([cur - 1, [*path, cur - 1]])
