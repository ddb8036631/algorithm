import sys

input = sys.stdin.readline
N, M = map(int, input().split())
nodes = sorted([list(map(int, input().split())) for _ in range(M)], key=lambda x: x[2])
parent = [i for i in range(N + 1)]
towns = N
answer = 0


def find(x):
    if x != parent[x]:
        parent[x] = find(parent[x])
    return parent[x]


def union(x, y):
    px, py = find(x), find(y)
    if px > py:
        parent[px] = py
    else:
        parent[py] = px


for a, b, c in nodes:
    if towns == 2:
        break
    if find(a) == find(b):
        continue
    union(a, b)
    towns -= 1
    answer += c

print(answer)
