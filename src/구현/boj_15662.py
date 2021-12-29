import sys


def rotate(arr, dir):
    for i, d in enumerate(dir):
        if d == 0:
            continue
        arr[i] = [arr[i][-1]] + arr[i][: len(arr[i]) - 1] if d == 1 else arr[i][1:] + [arr[i][0]]


def calc(arr):
    ret = 0
    for a in arr:
        ret += int(a[0])
    return ret


input = sys.stdin.readline
T = int(input().strip())
arr = [list(input().strip()) for _ in range(T)]
K = int(input().strip())
for _ in range(K):
    i, d = map(int, input().strip().split())
    i -= 1
    left, right = i - 1, i + 1
    dir = [0] * T
    dir[i] = d

    while left >= 0:
        if arr[left][2] == arr[left + 1][6]:
            break
        dir[left] = -(dir[left + 1])
        left -= 1
    while right < T:
        if arr[right][6] == arr[right - 1][2]:
            break
        dir[right] = -(dir[right - 1])
        right += 1

    rotate(arr, dir)

print(calc(arr))
