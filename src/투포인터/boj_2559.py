N, K = map(int, input().split())
arr = [*map(int, input().split())]
left, right = 1, K
answer = s = sum(arr[:right])

while right < N:
    s = s - arr[left - 1] + arr[right]
    answer = max(answer, s)
    left += 1
    right += 1

print(answer)
