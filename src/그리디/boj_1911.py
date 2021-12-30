import math

N, L = map(int, input().split())
arr = []
for _ in range(N):
    s, e = map(int, input().split())
    arr.append((s, e))

arr.sort(key=lambda x: (x[0], x[1]))
last, answer = 0, 0

for s, e in arr:
    if s <= last:
        s = last + 1
        if s >= e:
            continue

    cnt = math.ceil((e - s) / L)
    last = max(last, s + cnt * L - 1)
    answer += cnt

print(answer)
