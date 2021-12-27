A, B, C = map(int, input().split())
cnt = [0] * 100
answer = 0

for _ in range(3):
    s, e = map(int, input().split())
    for i in range(s, e):
        cnt[i] += 1

for i in range(1, 100):
    if cnt[i] == 1:
        answer += A
    elif cnt[i] == 2:
        answer += B * 2
    elif cnt[i] == 3:
        answer += C * 3

print(answer)
