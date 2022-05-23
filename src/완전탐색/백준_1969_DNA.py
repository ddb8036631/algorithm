N, M = map(int, input().split())
DNA = sorted([input() for _ in range(N)])
target, min_hd = "", 0

for j in range(M):
    cnt = [[0, "A"], [0, "C"], [0, "G"], [0, "T"]]

    for i in range(N):
        if DNA[i][j] == "A":
            cnt[0][0] += 1
        elif DNA[i][j] == "C":
            cnt[1][0] += 1
        elif DNA[i][j] == "G":
            cnt[2][0] += 1
        else:
            cnt[3][0] += 1

    cnt.sort(key=lambda x: (-x[0], x[1]))
    target += cnt[0][1]
    min_hd += N - cnt[0][0]

print(target, min_hd, sep="\n")
