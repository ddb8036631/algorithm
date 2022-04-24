N = int(input())
info = list(map(int, input().split()))
answer = [0 for _ in range(N)]

for i in range(N):
    left = info[i]

    for j in range(N):
        if left == 0 and answer[j] == 0:
            answer[j] = i + 1
            break
        elif answer[j] == 0:
            left -= 1

print(*answer)
