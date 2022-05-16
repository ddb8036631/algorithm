from collections import deque

n, w, L = map(int, input().split())
trucks = list(map(int, input().split()))
idx = 0
cur_time = 1
weight = 0
queue = deque()

while True:
    if idx == n:
        break

    if queue and queue[0][1] == cur_time:
        truck, end_time = queue.popleft()
        weight -= truck

    if weight + trucks[idx] <= L:
        queue.append([trucks[idx], cur_time + w])
        weight += trucks[idx]
        idx += 1

    cur_time += 1

while queue:
    truck, end_time = queue.popleft()
    cur_time += end_time - cur_time

print(cur_time)
