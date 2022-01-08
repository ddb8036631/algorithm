from sys import stdin
from collections import defaultdict
from heapq import heappush, heappop

input = stdin.readline
N = int(input())
min_heap, max_heap = [], []
solved = defaultdict(bool)
for _ in range(N):
    P, L = map(int, input().split())
    heappush(max_heap, (-L, -P))
    heappush(min_heap, (L, P))
    solved[P] = False
M = int(input())
for _ in range(M):
    command = input().split()
    if command[0] == "recommend":
        if command[1] == "1":
            while solved[-max_heap[0][1]]:
                heappop(max_heap)
            print(-max_heap[0][1])
        elif command[1] == "-1":
            while solved[min_heap[0][1]]:
                heappop(min_heap)
            print(min_heap[0][1])
    elif command[0] == "add":
        while solved[-max_heap[0][1]]:
            heappop(max_heap)
        while solved[min_heap[0][1]]:
            heappop(min_heap)
        heappush(max_heap, (-int(command[2]), -int(command[1])))
        heappush(min_heap, (int(command[2]), int(command[1])))
        solved[int(command[1])] = False
    elif command[0] == "solved":
        solved[int(command[1])] = True
