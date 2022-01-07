from collections import defaultdict
from sys import stdin

input = stdin.readline
dic = defaultdict(int)
for _ in range(int(input())):
    dic[input().strip().split(".")[1]] += 1

answer = sorted(list(map(list, zip(dic.keys(), map(str, dic.values())))), key=lambda x: x[0])
for arr in answer:
    print(arr[0], arr[1])
