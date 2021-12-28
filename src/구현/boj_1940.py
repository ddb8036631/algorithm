N = int(input())
M = int(input())
arr = sorted(list(map(int, input().split())))
left, right = 0, N - 1
answer = 0

while left < right:
    s = arr[left] + arr[right]

    if s > M:
        right -= 1
    elif s < M:
        left += 1
    else:
        answer += 1
        left += 1
        right -= 1

print(answer)
