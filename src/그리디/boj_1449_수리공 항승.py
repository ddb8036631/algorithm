N, L = map(int, input().split())
arr = sorted(list(map(int, input().split())))
cover, cnt = 0, 0

for n in arr:
    if cover < n:
        cover = n + L - 1
        cnt += 1

print(cnt)
