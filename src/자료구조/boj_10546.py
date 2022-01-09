from sys import stdin
from collections import defaultdict


input = stdin.readline
N = int(input())
dic = defaultdict(int)
for _ in range(N):
    dic[input().strip()] += 1
for _ in range(N - 1):
    end = input().strip()
    dic[end] -= 1
    if not dic[end]:
        del dic[end]
print(*dic)
