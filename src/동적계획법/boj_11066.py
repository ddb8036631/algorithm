T = int(input())

for _ in range(T):
    K = int(input())
    L = [0] + list(map(int, input().split()))
    dp = [[0 for _ in range(K + 1)] for _ in range(K + 1)]
    sum = [0 for _ in range(K + 1)]

    for i in range(1, K + 1):
        sum[i] = sum[i - 1] + L[i]

    for i in range(2, K + 1):
        for j in range(1, K + 2 - i):
            dp[j][j + i - 1] = (
                min([dp[j][j + k] + dp[j + k + 1][j + i - 1] for k in range(i - 1)]) + sum[j + i - 1] - sum[j - 1]
            )

    print(dp[1][K])
