n, k = map(int, input().split())
dp = [1e9 for _ in range(k + 1)]
coin = sorted([int(input()) for _ in range(n)])
dp[0] = 0

for i in range(1, k + 1):
    for c in coin:
        if i - c < 0:
            break
        dp[i] = min(dp[i], dp[i - c] + 1)

print(-1 if dp[k] == 1e9 else dp[k])
