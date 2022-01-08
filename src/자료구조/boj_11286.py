from sys import stdin
from heapq import heappush, heappop

input = stdin.readline
abs_heap = []
for _ in range(int(input())):
    x = int(input())
    if x == 0:
        print(heappop(abs_heap)[1] if abs_heap else 0)
    else:
        heappush(abs_heap, (abs(x), x))
