T = int(input())
MOD = 1000000009
LIMIT = int(1e6) + 1
arr = [0] * LIMIT
arr[0], arr[1], arr[2] = 1, 1, 2

for i in range(3, LIMIT):
    arr[i] = (arr[i - 1] + arr[i - 2] + arr[i - 3]) % MOD

for _ in range(T):
    print(arr[int(input())])
