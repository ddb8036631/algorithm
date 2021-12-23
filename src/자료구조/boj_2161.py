from collections import deque

n = int(input())
d = deque([str(x) for x in range(1, n + 1)])
drop = []

while len(d) != 1:
    drop.append(d.popleft())
    d.append(d.popleft())

drop.append(d.popleft())

print(" ".join(drop))
