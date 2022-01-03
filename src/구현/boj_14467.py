N = int(input())
answer = 0
cow = {}
for _ in range(N):
    idx, loc = map(int, input().split())
    if idx - 1 in cow:
        if cow[idx - 1] != loc:
            answer += 1

    cow[idx - 1] = loc

print(answer)
