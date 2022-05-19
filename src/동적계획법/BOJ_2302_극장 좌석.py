N = int(input())
M = int(input())
vips = [int(input()) for _ in range(M)]
dp = [0 for _ in range(N + 1)]
dp[0], dp[1] = 1, 1
prev = 0
answer = 1

for i in range(2, N + 1):
    dp[i] = dp[i - 1] + dp[i - 2]

for vip in vips:
    answer *= dp[vip - prev - 1]
    prev = vip
answer *= dp[N - prev]

print(answer)
