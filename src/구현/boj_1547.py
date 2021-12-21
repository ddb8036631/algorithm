n = int(input())
arr = [0, 1, 2, 3]
for _ in range(n):
    a, b = map(int, input().split())
    arr[a], arr[b] = arr[b], arr[a]
print(arr.index(1))
