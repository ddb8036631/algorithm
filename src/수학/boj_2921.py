N = int(input())
arr = [0] * (N + 1)
arr[1] = 3
delta = 6

for i in range(2, N + 1):
    arr[i] = arr[i - 1] + delta
    delta += 3

print(sum(arr))
