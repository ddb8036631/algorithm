from collections import deque

F, S, G, U, D = map(int, input().split())
queue = deque()
visit = [False] * 1000001
queue.append(S)
visit[S] = 1

while queue:
    now = queue.popleft()
    if now == G:
        print(visit[now] - 1)
        exit()
    if now + U <= F and visit[now + U] == 0:
        visit[now + U] = visit[now] + 1
        queue.append(now + U)
    if now - D >= 1 and visit[now - D] == 0:
        visit[now - D] = visit[now] + 1
        queue.append(now - D)

print("use the stairs")
