N = int(input())
max_left, max_height, top = 0, 0, -1
l = []
answer = 0

for _ in range(N):
    L, H = map(int, input().split())
    l.append([L, H])
    max_left = max(max_left, L)

    if max_height < H:
        max_height = H
        top = L

pillars = [0 for _ in range(max_left + 1)]

for L, H in l:
    pillars[L] = H

tmp = 0
for i in range(top + 1):
    if tmp < pillars[i]:
        tmp = pillars[i]
    answer += tmp

tmp = 0
for i in range(max_left, top, -1):
    if tmp < pillars[i]:
        tmp = pillars[i]
    answer += tmp

print(answer)
