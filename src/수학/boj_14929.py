n = int(input())
arr = list(map(int, input().split()))
sum = [0] * n
sum[0] = arr[0]
answer = 0

for i in range(1, n):
    sum[i] = sum[i - 1] + arr[i]

for i in range(n - 1):
    answer += arr[i] * (sum[-1] - sum[i])

print(answer)
