from collections import defaultdict
import sys

input = sys.stdin.readline
N = int(input())
dic = defaultdict(int)

for _ in range(N):
    name = input()
    dic[name[0]] += 1

l = list(filter(lambda x: x != None, list(map(lambda x: x if dic[x] >= 5 else None, dic))))
print("PREDAJA" if len(l) == 0 else "".join(sorted(l)))
