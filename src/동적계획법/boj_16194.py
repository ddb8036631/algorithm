import sys

input = sys.stdin.readline
n = int(input())
l = [0, *map(int, input().split())]
dp = [10000] * (n + 1)
dp[0] = 0

for i in range(1, n + 1):
    for j in range(1, i + 1):
        dp[i] = min(dp[i], dp[i - j] + l[j])

print(dp)
print(dp[n])
