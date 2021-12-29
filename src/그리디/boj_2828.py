N, M = map(int, input().split())
J = int(input())
left, right = 1, M
answer = 0

for _ in range(J):
    next = int(input())
    if left <= next <= right:
        continue

    if next > right:
        answer += next - right
        left += next - right
        right = next
    elif next < left:
        answer += left - next
        right -= left - next
        left = next

print(answer)
