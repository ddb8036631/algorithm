N = int(input())
T = [0] * N
P = [0] * N
dp = [0] * (N + 1)

for i in range(0, N):
    T[i], P[i] = map(int, input().split(" "))

for i in range(N - 1, -1, -1):
    dp[i] = max(dp[i + 1], dp[i + T[i]] + P[i]) if i + T[i] <= N else dp[i + 1]


print(dp[0])
