def find(x):
    if x == parent[x]:
        return x
    parent[x] = find(parent[x])
    return parent[x]


def union(x, y):
    px, py = find(x), find(y)
    if px >= py:
        parent[px] = py
    else:
        parent[py] = px


V, E = map(int, input().split())
adj = sorted([list(map(int, input().split())) for _ in range(E)], key=lambda x: x[2])
parent = [i for i in range(V + 1)]
cnt, answer = 0, 0


for A, B, C in adj:
    pa, pb = find(A), find(B)
    if pa == pb:
        continue

    union(A, B)
    answer += C
    cnt += 1

    if cnt == V - 1:
        break

print(answer)
