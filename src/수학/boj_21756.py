N = int(input())
arr = [x for x in range(1, N + 1)]

while True:
    if len(arr) == 1:
        break
    del arr[: len(arr) : 2]

print(arr[0])
