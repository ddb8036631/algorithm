from itertools import combinations, permutations

N = int(input())
S = [list(map(int, input().split(" "))) for _ in range(N)]
l = [i for i in range(N)]
comb = list(combinations(l, N // 2))
answer = float("inf")

for i in range(len(comb) // 2):
    start = list(permutations(comb[i], 2))
    link = list(permutations(comb[len(comb) - i - 1], 2))
    startSum, linkSum = 0, 0

    for i, j in start:
        startSum += S[i][j]
    for i, j in link:
        linkSum += S[i][j]

    answer = min(answer, abs(startSum - linkSum))

print(answer)
