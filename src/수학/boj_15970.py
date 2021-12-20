import sys


def calc(arr):
    sum = 0
    for i in range(len(arr)):
        if i == 0:
            sum += arr[1] - arr[0]
        elif i == len(arr) - 1:
            sum += arr[i] - arr[i - 1]
        else:
            sum += arr[i] - arr[i - 1] if arr[i + 1] - arr[i] >= arr[i] - arr[i - 1] else arr[i + 1] - arr[i]

    return sum


input = sys.stdin.readline
N = int(input())
answer = 0
arr = []

for _ in range(N):
    a, b = map(int, input().split())
    arr.append([b, a])

arr.sort()
l = arr[-1][0]

for color in range(1, l + 1):
    x = []
    for i in range(N):
        if arr[i][0] == color:
            x.append(arr[i][1])
    answer += calc(x)

print(answer)
