from sys import stdin
from heapq import heappush, heappop

input = stdin.readline
max_heap = []
for _ in range(int(input())):
    x = int(input())
    if x == 0:
        print(-heappop(max_heap) if max_heap else 0)
    else:
        heappush(max_heap, -x)
